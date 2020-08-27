package _726;

import java.io.Serializable;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2610:02
 */
public class Search {
    public int search(int[] nums, int target) {
        /*
        二分法：
        对于局部有序的数组如何使用二分法？
         当我们根据left与right找到了mid之后，我们先看mid是否是我们要找的元素，是就返回index
         不是就要判断出来是left->mid-1有序还是mid+1->right有序。[不管mid在哪儿肯定有一个是有序的]
         若left->mid-1有序，就去判断target是否在该范围内，在则right=mid-1，否则就left=mid+1
         若mid+1->right有序，处理同。
        */
        return binarySearch(0,nums.length-1,nums,target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if (nums[mid]==target) {
            return mid;
        }
        //左边有序  有无等于？
        //什么时候往左边去？ 左边有元素  且
        //在判断左边有序时 使用 left与mid-1  与 left与mid  比较的区别？
        //基于上述  我们仅知道mid无越界  如果使用mid-1 或者mid+1去判断是否越界 或target是否在区间内，我们还要确保mid-1 +1存在。
        //使用mid
        if(nums[left]<=nums[mid]){
            if (nums[left]<=target&&nums[mid]>=target){
                return binarySearch(left, mid-1, nums, target);
            }else {
                return binarySearch(mid+1, right, nums, target);
            }
        }
        //肯定有一边有序，左边无则右边有
        else {
            if(target<=nums[right]&&target>=nums[mid]){
                return binarySearch(mid+1, right, nums, target);
            }else {
                return binarySearch(left, mid-1, nums, target);
            }
        }
    }

    public static void main(String[] args) {
        Search search=new Search();
        int nums[]={1,3};
        System.out.println(search.search(nums, 3));
    }
}
