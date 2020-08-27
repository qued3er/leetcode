package _85;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/510:12
 */
public class FindMin2 {
    /*迭代法*/
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            if (left==right){
                break;
            }
            int mid=(left+right)/2;
            //什么时候return？
            if (nums[mid]>nums[right]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMin2 findMin2=new FindMin2();
        int []nums={3,4,5,1,2};
        System.out.println(findMin2.findMin(nums));
    }
}
