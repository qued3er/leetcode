package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2212:57
 */
//最长上升子序列
    //首先如果我们使用暴力  即求以每一个元素开头的最长子序列，然后求最大。会有许多的重复的计算。
    //例如10,9,2,5,3,7,101,18 在求以2，3开头的最长子序列时都把以7开头的算了一遍所以我们可以使用动态规划，从短往
    //长去计算 首先是长度仅为1的子序列 也就是最后一个元素，然后计算以倒数第二个开头的...
    //其最长应该是 1+以比它大的 在它之后的最大长度。 如果没有比他大的 就是1。
// 状态转移方程为:dp[i]=1+dp[i+x] nums[i+x]为i之后的>nums[i]的元素且长度最长的元素。
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int []dp=new int[nums.length];
        dp[nums.length-1]=1;
        for (int i=nums.length-2;i>=0;i--){
            int max=0;
            //找在该元素之后 nums比它大的    且dp最大的
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]>nums[i]&&dp[j]>max){
                    max=dp[j];
                }
            }
            if (max==0){
                dp[i]=1;
            }else {
                dp[i]=max+1;
            }
        }
        //在dp数组中找最大的
        int max=0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS=new LengthOfLIS();
        int[]nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }
}
