package _815;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1513:57
 */
//最优问题  ===》动态规划
    //状态转移方程：求最大值
    //抽象出来 假设dp[k]为前k家能拿到的最大值。

// 对与一家点k，如果我们拿k则，k-1不能拿，那么从开始到k点的最大值为dp[k]=dp[k-2]+nums[k]
//如果不拿k，则，则dp[k]=dp[k-1]
//所以我们可以通过一个数据来完成 即：底为dp[1]=nums[1] dp[2]=nums[2]
    //更新dp[3]...一直到dp[k]



    //基于dp[i]>=dp[j]  i>j
public class Rob {
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=3;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        Rob rob=new Rob();
        int []nums={2,1,1,2};
        System.out.println(rob.rob(nums));
    }
}
