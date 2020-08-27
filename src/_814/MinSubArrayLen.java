package _814;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/149:08
 */
public class MinSubArrayLen {
    //首先在数组中找到第一个刚好>s的子数组，然后该子数组逐个的向后延伸，延伸的同时可以减去前边的对应的数使得该子数组仍然>3
    //对比该数组的长度与之前数组的长度进行最短更新。  需要维持当前数组的和的大小
    public int minSubArrayLen(int s, int[] nums) {

        //首先找到第一个>=s的子数组的结束为止并记录其和。
        int start=0;
        int end=0;
        int sum=0;
        int minLength=0;
        for (int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if (sum>=s){
                end=i;
                break;
            }
        }
        //木有满足要求的
        if (sum<s){
            return 0;
        }
        //*************要满足子数组不>=s要满足当前子数组是刚好>=s的 ，其子数组不能是         如果是 1，2,3,4,5  11 则不满足
        for (int i=start;i<=end;i++){
            if (sum-nums[i]>s){
                sum=sum-nums[i];
                start++;
            }else {
                break;
            }
        }
        minLength=end-start+1;
        //从end逐个进行延伸
        for (int i = end+1; i < nums.length; i++) {
            sum=sum+nums[i];
            for (int j=start;j<=end+1;j++){
                if (sum-nums[j]>=s){
                    sum=sum-nums[j];
                    start++;
                }else {
                    break;
                }
            }
            end++;
            if((end-start+1)<minLength){
                minLength=end-start+1;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen=new MinSubArrayLen();
        int []nums={1,2,3,4,5};
        System.out.println(minSubArrayLen.minSubArrayLen(11, nums));
    }
}
