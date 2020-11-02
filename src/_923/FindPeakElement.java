package _923;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/227:45
 */
public class FindPeakElement {
    /**
     * 元素互不相等，且nums[-1]==nums[n]=-无穷  一定存在拐点
     * 要求O(lgn)，所以想到折半， 最大值的特点就是左剩右降而且我们随便找到一个即可===》使用折半可行
     * 把这个数组看成多个上升/下降的序列，若当前处于上升拐点在右，若当前处于下降，拐点在左。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (mid==nums.length-1){
                return mid;
            }
            if (nums[mid]<nums[mid+1]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement=new FindPeakElement();
        //
        int []nums={1,2,3,4,5,6};
        System.out.println(findPeakElement.findPeakElement(nums));
    }
}
