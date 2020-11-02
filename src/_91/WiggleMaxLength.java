package _91;

import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/1   8:36
 */

public class WiggleMaxLength {
    /* 292,9,64,156,153,26,145,196,222  这个解法有问题
    * 因为我们的状态转义方程判断的是 i i+1 i+2的关系  这个逻辑是错的
    * nums = [1,17,5,10,13,15,10,5,16,8]
        nums[2] 即数值 5， 既可以属于 [1, 5] 与前一个相比为上升， 也可以属于 [1, 17, 5] 与前一个相比为下降，
    * 由于不知道后面数子的情况， 所以 5 属于这两种不同情况的数值也必须保留
    * 1 17 5 1 4 3 2
*/
    /*public int wiggleMaxLength(int[] nums) {

        if (nums.length==0){
            return 0;
        }else if (nums.length==1){
            return 1;
        }
//        /*动态规划 从后向前作为起点逐渐得出最长
        int[]maxLength=new int[nums.length];
        int length=nums.length;
        if (nums[length-1]==nums[length-2]){
            maxLength[length-2]=1;
        }else {
            maxLength[length-2]=2;
        }
        for (int i=maxLength.length-3;i>=0;i--){
            //一正一负可加1       否则继承前值
            if ((nums[i]>nums[i+1]&&nums[i+1]<nums[i+2])||(nums[i]<nums[i+1]&&nums[i+1]>nums[i+2])){
                maxLength[i]=maxLength[i+1]+1;
            }else {
                maxLength[i]=maxLength[i+1];
            }
        }
        return maxLength[0];
    }
    */

    /**
     * 维持两个数组一个是最后一个是升序的,且end为i的最长升序，对应的是降序。
     * up[0]=1 down[0]=1
     * 状态转移方程为：up[i]=max(up[i-1],down[i-1]+1)  down[i]=max(down[i-1],up[i-1]+1)
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int [] up=new int[nums.length];
        int []down=new int[nums.length];
        up[0]=1;
        down[0]=1;
        for (int i=1;i<up.length;i++){
            //为什么仅仅和前一个元素 比较即可以判断能否+1
            if (nums[i]<nums[i-1]){
                up[i]=Math.max(up[i-1],down[i-1]+1);
                down[i]=down[i-1];
            }else if(nums[i]>nums[i-1]){
                up[i]=up[i-1];
                down[i]=Math.max(down[i-1],up[i-1]+1);
            }else {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }
    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength=new WiggleMaxLength();
        int []nums={2,3,4,1,5,17,1};
//        System.out.println(nums.length);
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums));
    }
}
