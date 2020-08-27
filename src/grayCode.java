import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2512:43
 */
public class grayCode{
    public List<Integer> grayCode(int n) {
        /*
        与动态规划有点类似：
        递归+镜像：
        首先为什么要使用递归？
        因为我们在指导n-1为的格雷编码时，可以根据n-1位的格雷编码构造n位的格雷编码。
        1位时： 0 1
        2位时： 00 01 10 11
        上述按照1位时的顺序构造  先在1位的graycode之前加0[之后呢？ 相同处理] 再在1位的grraycode前加1
        为什么这样可以构造？
        因为1位时顺序满足gray，然后在其前加0或者加1，都还是仅仅一位不同  因为都补得0或1。
        但是交界处又出现了问题  01 与 10
        此时相差的不是1位。==》采用镜像。
        为什么采用镜像？
        因为我们的整体顺序为：补0 补1 在补0和补1之间有一个跳转 又返回初始部位开始补，这样肯定不连续
        ex:两位的 00 01 11 10     三位的 000 001 011 010  如果从头 100  如果逆向 相当于连接处 对10 前先
        0  然后 1 肯定符合要求
        若我们在补1时逆向  那么就相当于连接处 仅头位的0 1 不同  完成要求
        */
        /*具体实现：
         * 注意到：根据n-1生成n的时候，前加0就没动。 所以仅用逆序前加1.
         * 逆序前加1与当前是第几位的格雷吗有关，如果产生的是n位的格雷码那么就 +2的n-1次方*/
        List<Integer> res=new ArrayList<>();
        //底
        res.add(0);
        //记录前加1 到底是加几
        int index=1;
        //控制格雷码的长度
        for(int i=0;i<n;i++){
            //逆序遍历生成前序为1的。
            for(int j=res.size()-1;j>=0;j--){
                res.add(res.get(j)+index);

            }
            index=index<<1;
        }
        return res;
    }

    public static void main(String[] args) {
        grayCode grayCode=new grayCode();
        System.out.println(grayCode.grayCode(3));
    }
}


