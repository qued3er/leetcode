package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2219:03
 */
//找第n个丑数
    //1是丑数  1 2 3 4 5 6 8 9 10 12
    // 第i个丑数 肯定是前边的某个元素*2/3/5得到的，所以我们需要维持 该元素的index,当某个元素*2得到了当前的下一个丑数
    //时，则要想*2产生更大的丑数 需要index往前加。  对于3/5同样，而我们是想产生当前的下一个丑数、所以我们需要维持
    //*2可得到的下一个最小的丑数  *3 可得到的下一个最小的丑数 *5可得到的最小的丑数
    //他们三者的最小的那个就是下一个丑数。  假设下一个是*2产生的 那么下一个*2可得到的下一个最小的丑数的对应的
    //index就要++。
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int []dp=new int[n];
        dp[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        for (int i=1;i<dp.length;i++){
            int value2=dp[index2]*2;
            int value3=dp[index3]*3;
            int value5=dp[index5]*5;
            int min=Math.min(Math.min(value2, value3), value5);
            dp[i]=min;
            //更新 index的标准 并不是else只更新一个index 如果 产生的同一个丑数则都要更新
            if (min==value2){
                index2++;
            }
            if(min==value3){
                index3++;
            }
            if (min==value5){
                index5++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber=new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
    }
}
