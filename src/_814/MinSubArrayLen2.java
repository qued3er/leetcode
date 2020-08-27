package _814;



/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/14 10:17
 */
//涉及连续子数组的问题，我们通常有两种思路：一是滑动窗口、二是前缀和。
// 专项学习连续子数组=====》8.15




//tip:在进行二分查找的时候我们找的不是数组中元素，而是数组中的元素减去某个值或者加上某个值，那么我们在调用二分查找的时
// 候，传入要查找的元素，直接把target修改为 target+/-该值。而不是在二分的时候对每个元素都减去某个值，这样十分清晰[因为查找
// 的是数组中的元素等于某个值  而不是数组中的元素减去或者加上一个数等于某个值]。




// 最容易想到的暴力破解       找以每个元素起始的的最短的  然后对比他们的长度找到最小的。
    //时间复杂度  每个元素起始都要找    找以某个元素起始 [其后逐个+判断]O(n),所以O(n2)
    //依据其都是正整数  可以对其使用二分法查找===》通过维护一个sum数组。sum[i]表示前i-1一个元素相加得到的结果。为了
    //便于求以i起始的最小子数组时的减法找是去左还是去右。
public class MinSubArrayLen2 {
    public int minSubArrayLen(int s, int[] nums) {
        //初始化sum数组
        int []sums=new int[nums.length+1];
        sums[0]=0;
        int sum=0;
        for (int i = 1; i < sums.length; i++) {
            sum=sum+nums[i-1];
            sums[i]=sum;
        }
        if (sum<s){
            return 0;
        }
        int minlength=Integer.MAX_VALUE;
        //逐个找以每个元素起始的最短连续子数组[通过二分法]
        for (int i = 0; i < nums.length; i++) {
            //可能会以当前元素起始找不到满足条件的  那么其之后的都不满足条件  所以可以早返回
            int index=binarySearch(i,nums.length,sums,s+sums[i]);
            if (index==-1){
                break;
            }
            if ((index-i)<minlength){
                minlength=index-i;
            }
        }
        return minlength;
    }
    //直接找元素  不是找值本身 而是找第一个>=target的位置
    private int binarySearch(int start, int end, int[] sums,  int target) {
        while (start<=end){
            int mid=(start+end)/2;
            if (start==end){
                break;
            }
            if (sums[mid]<target){
                start=mid+1;
            }else {
                end=mid;
            }
        }
        if (sums[end]>=target) {
            return end;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MinSubArrayLen2 minSubArrayLen2=new MinSubArrayLen2();
        int[]nums={2,3,1,2,4,3};
        minSubArrayLen2.minSubArrayLen(7, nums);
    }
}
