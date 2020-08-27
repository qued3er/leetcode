package _727;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/277:48
 */
public class Search2 {
    public boolean search(int[] nums, int target) {
        /*
        在I的基础之上添加了可能有重复元素的条件
        */
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //特殊情况：相等 此时可能出现1,2,3,4,1假有序。如何判断？==》此时mid！=target  且left==mid，我们把该left跳过。
            //因为它一定不为target。 从而去判断left+1->right
            if(nums[mid]==nums[left]){
                    left++;
            }
            //左边有序
            if(nums[left]<nums[mid]){
                if(target<=nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            //右边有序
            else{
                if(target<=nums[right]&&target>=nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2 search2=new Search2();
        int []nums={1,3,1,1,1};
        System.out.println(search2.search(nums, 3));
    }
}
