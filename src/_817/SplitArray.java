package _817;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1713:06
 */
//目的：使得最大连续子数组的和 的值最小
//以后进行二分采用可能会溢出的计算方法
    //返回值问题：如果条件使用的while(left<right)则返回时left==right 如果使用的是while(left<=right)那么返回时left>right 看你
    //需要最大值还是最小值  最大值left   最小值right

    //1.中值可能会溢出的求法
    //2.min的初始化  min是最大连续子数组的最小和   肯定是最大值单独一个数据了  所以是min<nums[i]  之前是min>nums[i]
    //3.二分法  的left=mid  与left=mid-1  与while min<||<=  ?    和return 哪个 的组合问题
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int min=0;
        int max=0;
        //初始化min与max
        for (int i = 0; i < nums.length; i++) {
            //之前是大于 改成小于就过了
            if (min<nums[i]){
                min=nums[i];
            }
            max=max+nums[i];
        }
//        if ()
        //二分的去确定最大子数组的最小值
        while (min<=max){
//            min+max会超过int类型的值

            int mid=min+(max-min)/2;
            if (check(mid,nums,m)){
                //为什么不行？
                max=mid-1;
//                max=mid;
            }else {
                min=mid+1;
            }
        }
        return min;
    }

    private boolean check(int maxSubArrayValue, int[] nums, int m) {
        //数组个数
        int number=1;
        int sum=nums[0];
        for (int i=1;i<nums.length;i++){
            if ((sum+nums[i])>maxSubArrayValue){
                sum=nums[i];
                number++;
            }else {
                sum=sum+nums[i];
            }
        }
        if (number<=m){
            return true;
        }
        //需要更多的数组  当前最大太小 需要扩大
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        SplitArray splitArray=new SplitArray();
        int []nums={1,2147483647};
        System.out.println(splitArray.splitArray(nums, 2));
    }
}
