package _85;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/511:22
 */
public class MaxProduct2 {
    /*通过两个数组来完成动态规划。
    * max与min数组：
    * max[i]数组表示以第i个元素结尾的最大子数组的值。[注意：由于我们的max[i]表示的是以i结尾的最大子数组的值，所以我们的状态
    * 转移方程为max(max[i-1]*nums[i],nums[i])]。
    * =====》之前一直在考虑跳跃问题，即前边的最大值的end与i不连。
    *
    * 由于存在负负得正的情况，上述状态转义方程错误，所以我们需要维护一个min数组来存最小值
    * 那么当我们遇到一个正数时，其max[i]=max[i-1]*nums[i],nums[i]  因为正数期望一个大的数与他结合使得它最大
    * [max[i-1]为正，未负，为0]。==》min[i-1]*nums[i]多余。
    * 当我们遇到一个负数时，其max[i]=min[i-1]*nums[i],nums[i]  负数期望一个最小的数结合，使得它有可能负负为正。 max[i-1]与min[i-1]当两者均为
    * 负，那么取min肯定最大，当两者均为正那么肯定取min，当一正一负[一定为max正min负]，肯定取min===》所以max[i-1]*nums[i]是多余的。
    *
    * min数组的状态转移：
    * 当遇到正数时，min[i]=min[i-1]*nums[i],nums[i]
    * 当遇到负数时，min[i]=max[i-1]*nums[i],nums[i]
    * */
    public int maxProduct(int[] nums) {
        int []max=new int[nums.length];
        int[]min=new int[nums.length];
        max[0]=nums[0];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            //为了减少ifElse
            max[i]=Math.max(Math.max(max[i-1]*nums[i],nums[i]), min[i-1]*nums[i]);
            min[i]=Math.min(Math.min(min[i-1]*nums[i],nums[i]), max[i-1]*nums[i]);
        }
        int maxValue=max[0];
        for (int i =1;i<max.length;i++){
            if (max[i]>maxValue){
                maxValue=max[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        MaxProduct2 maxProduct2=new MaxProduct2();
        int []nums={-2,1,-1};
        System.out.println(maxProduct2.maxProduct(nums));
    }
}
