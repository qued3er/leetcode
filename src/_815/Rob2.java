package _815;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1514:39
 */
//与打家劫舍1的区别在于首尾连
// 之前在仅是一条直线的时候我们找底dp[0]不会影响尾部的选择
//而现在我们要把环拆开 ===》在dp[0]这拆开  我们选择nums[0]则尾不能选  也就是求nums[:length-1]
// 如果我们不选 则尾可以选 nums[1:] 所以编程了两条直线求最大值
    //相当于是剔除一个元素使其不能成环
public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        //处理长度>=2
        int max1=findMax(nums,0,nums.length-2);
        int max2=findMax(nums,1,nums.length-1);
        return Math.max(max1, max2);
    }
//nums与start和end对应  dp从0开始
    private int findMax(int[] nums, int start, int end) {
        int[]dp=new int[nums.length-1];
        dp[0]=nums[start];
        if (start==end){
            return dp[0];
        }
        dp[1]=Math.max(nums[start],nums[start+1]);
        if (start+1==end){
            return dp[1];
        }
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        Rob2 rob2=new Rob2();
        int []nums={0,0};
        System.out.println(rob2.rob(nums));
    }
}
