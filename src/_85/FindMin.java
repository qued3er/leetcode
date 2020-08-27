package _85;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/59:46
 */
public class FindMin {
    /*
    * 旋转了一下的升序的排序数组中的最小值：找旋转点
    * 假设不存在重复元素
    * */
    public int findMin(int[] nums) {
        int min=binSearch(nums,0,nums.length-1);
        return min;
    }

    private int binSearch(int[] nums, int start, int end) {
        int mid=(start+end)/2;
        if (nums[mid]>=nums[start]&&nums[mid]<=nums[end]){
            return nums[start];
        }
        if (nums[mid]>=nums[start]&&nums[mid]>=nums[end]){
            return binSearch(nums, mid+1, end);
        }else {
            return binSearch(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        FindMin findMin=new FindMin();
        int []nums={9,10,11,1,2,3,4,5,6};
        System.out.println(findMin.findMin(nums));
    }
}
