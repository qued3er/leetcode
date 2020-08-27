package _82;

import _726.Search;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/29:08
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        /*之前我们的二分是找到就结束。 我们可以通过修改结束条件来找到target的第一个和最后一个元素
        。*/
        int [] res=new int [2];
        res[0]=-1;
        res[1]=-1;
        int start=0;
        int end=nums.length-1;
        //找到起始
        while (start<=end){
            int mid=(start+end)/2;
            //注意第一个元素无前一个元素
            if (target==nums[mid]&&(mid==0||nums[mid]!=nums[mid-1])){
                res[0]=mid;
                break;
            }
            if (target<=nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        start=0;
        end=nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (target==nums[mid]&&(mid==nums.length-1||nums[mid]!=nums[mid+1])){
                res[1]=mid;
                break;
            }
            if (target<nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums={1};
        SearchRange searchRange=new SearchRange();
        int[] res = searchRange.searchRange(nums, 1);
        System.out.println(res[0]);
        System.out.println(res[1]);
//        System.out.println('1');
    }
}
