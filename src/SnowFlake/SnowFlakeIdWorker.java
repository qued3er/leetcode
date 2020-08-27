package SnowFlake;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/819:36
 */

public class SnowFlakeIdWorker {
    //开始时间戳
    private final long twepoch=1591616237l;
    private final long workIdBits=5l;
    private final long dataCenterIdBits=5l;
    //31，负数左移补0右移补1
    private final long maxWorkerId=-1L^(-1L<<workIdBits);
    private final long maxDataCenterId=-1L^(-1L<<dataCenterIdBits);
    //后12位解决同一ms的ID的冲突
    private final long sequenceBits=12l;
    //workerid的左移位数
    private final long workerIdShift=sequenceBits;
    //dataCenterID左移17位
    private final long dataCenterIdShift=sequenceBits+workIdBits;
    //时间戳左移
    private final long stampShift=sequenceBits+workIdBits+dataCenterIdBits;
    //同一ms内生成的id的掩码,
    private final long sequenceMask=-1l^(-1l<<sequenceBits);
    private long workerId;
    private long dataCenterId;
    //取得是时间差初始为0
    private long sequences=0l;
    //上次生成id的时间戳，防止时钟回调导致生成重复的id。
    private  long lastTimeStamp=-1l;
    //构造器,本机的id
    public SnowFlakeIdWorker(long workerId,long dataCenterId){
        if(workerId>workerId||workerId<0){
            throw new IllegalArgumentException(String.format(
                    "workId must greater than 0 and less than %d",maxWorkerId));
        }
        if(dataCenterId>maxDataCenterId||dataCenterId<0){
            throw new IllegalArgumentException(String.format(
                    "dataCenterId must greater than 0 and less than %d",maxDataCenterId));
        }
        this.workerId=workerId;
        this.dataCenterId=dataCenterId;
    }
    //获取下一个Id,线程安全
    public synchronized long nextId(){
        long timestamp=timeGen();
        //防止时钟回调
        if(timestamp<this.lastTimeStamp){
            throw  new RuntimeException("时钟回调可能会生成重复id");
        }
        //同一ms内的请求处理,考虑能不能用原子类==？未解决
        if(timestamp==lastTimeStamp){
            sequences=(sequences+1)&sequenceMask;
            //如果同一ms内的请求超过4095 则阻塞到下一ms,用下一ms的时间戳拿来使用。
            if(sequences==0){
                timestamp=tilNextMillls(lastTimeStamp);
            }
        }else {
            //置零
            sequences=0l;
        }
        lastTimeStamp=timestamp;
        //拼接出Id返回,与0异或得原值低位为0
        return (timestamp-twepoch)<<stampShift
                |dataCenterId<<dataCenterIdShift|workerId<<workerIdShift|sequences;
    }
    private long tilNextMillls(long lastTimeStamp) {
        long timestamp=timeGen();
        while(timestamp<=lastTimeStamp){
            timestamp=timeGen();
        }
        return timestamp;
    }
    private long timeGen() {
        return System.currentTimeMillis();
    }
    public static void main(String[] args) {
        SnowFlakeIdWorker snowFlakeIdWorker=new SnowFlakeIdWorker(12,17);
        for(int i=0;i<5;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++) {
                    System.out.println(snowFlakeIdWorker.nextId());
                }
            }).start();

        }
    }
}
