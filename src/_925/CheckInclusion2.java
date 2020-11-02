package _925;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/259:42
 */
public class CheckInclusion2 {
    /**
     * 通过滑动窗口来解决
     * 对s1的字符的频率生成一个hash表。
     * 对s2与s1长度相同的生成一个hash表，前挪后加。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        //首先对字符串s1的所有字符生成一个哈希表。
        char[] s1CharArray = s1.toCharArray();
        int []tableShort=new int[26];
        int[]tableLong=new int[26];
        char[]s2CharArray=s2.toCharArray();
        //为第一个长度相同的生成hash表
        for (int i = 0; i < s1CharArray.length; i++) {
            int indexShort=s1CharArray[i]-97;
            int indexLong=s2CharArray[i]-97;
            tableShort[indexShort]++;
            tableLong[indexLong]++;
        }
        if (verify(tableShort,tableLong)){
            return true;
        }
        //从第二个开始对比
        for(int i=1;i<=s2CharArray.length-s1CharArray.length;i++){
            //把前一个加上 后一个去了
            int before=s2CharArray[i-1]-97;
            tableLong[before]--;
            //index锁定有问题
            int after=s2CharArray[i+s1CharArray.length-1]-97;
            tableLong[after]++;
            if(verify(tableLong,tableShort)){
                return true;
            }
        }
        return false;
    }

    private boolean verify(int[] tableShort, int[] tableLong) {
        for (int i=0;i<tableShort.length;i++){
            if (tableLong[i]!=tableShort[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion2 checkInclusion2=new CheckInclusion2();
        System.out.println(checkInclusion2.checkInclusion("adc"
                ,"dcda"));
    }
}
