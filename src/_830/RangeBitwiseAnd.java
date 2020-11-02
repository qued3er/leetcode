package _830;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/3018:40
 */

public class RangeBitwiseAnd {
    /**
     * 按位与[m,n]的结果
     * 最基础的想法：一遍遍历 一个一个与  ==>超出时间限制
     * 需要考虑与运算特点  有0为0。
     * 5 101
     * 6 110
     * 7 111
     * 考虑：
     * n和m拥有相同的公共前缀 在公共前缀的后一位，一定是n的为0，m的为1
     * n为0abcdefg m为1hijklmn 从n->m的后缀一定会经过一个1000000所以 n和m与的结果就是其公共前缀。
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m==n){
            return m;
        }
        int mask=0x7fffffff;
        //逐位的判断公共前缀
        for (int i=0;i<32;i++){
            if ((m&mask)==(n&mask)){
                return m&mask;
            }
            mask=mask-(1<<i);
        }
        return 0;
    }

    public static void main(String[] args) {
        RangeBitwiseAnd rangeBitwiseAnd=new RangeBitwiseAnd();
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 7));
    }
}
