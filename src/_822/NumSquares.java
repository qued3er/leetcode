package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2220:38
 */
// n 可能由 比(n-i)到来，为比n小的所有的平方数。  所以
// dp[i]=min(dp[i-j*j]+1) j从1到n  n*n<i且n为可能的最大的数。
public class NumSquares {
    public int numSquares(int n) {
        int []dp=new int[n+1];
        //记录第一个大于i的平方根[平方比i小]
        int value=2;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            int min=Integer.MAX_VALUE;
            if ((value*value)<=i){
                value++;
            }
            for (int j=value-1;j>=1;j--){
                int index=i-j*j;
                //1是加上j方
                if (dp[index]+1<min){
                    min=dp[index]+1;
                }
            }
            dp[i]=min;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        NumSquares numSquares=new NumSquares();
        System.out.println(numSquares.numSquares(13));
    }
}
