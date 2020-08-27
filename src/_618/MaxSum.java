package _618;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/1815:08
 */
public class MaxSum {
    /*给定一个整数数组求其最大连续子数组的和*/
    public int maxSubSum(int [] nums){
        //动态规划 确定底
        //长度为1 时 max就是该元素 当两个元素的时候 max(max(0)+nums[1],nums[1]) 如果是前者，
        // 则cursum=max(1)+nums[1],如果是或者则cursum=nums【1】
        int maxSubSum=nums[0];
        int sum=nums[0];
        //遍历该数组，判断加上当前位是否比当前位的数值大，并入当前子数组，如果不大于则须重置该子数组的起始位置。
        for(int i=1;i<nums.length;i++){
            if(sum+nums[i]>nums[i]){
                sum=sum+nums[i];
            }else {
                //判断当前的sum是否比maxsum大
                sum=nums[i];
            }
            if(sum>maxSubSum){
                maxSubSum=sum;
            }
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        MaxSum maxSum=new MaxSum();
        int []nums={-1,2,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum.maxSubSum(nums));
    }
}
