package _726;

import _68.RemoveNthFromEnd;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2614:35
 */
public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        /*
        * 两个指针 1个用来指向被覆盖的位置  1个用来指向当前遍历的元素
        *   count用来记当前的元素的个数。
        * */
        if (nums.length==1){
            return 1;
        }
        int replace=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            /*分析几种情况：
            * 1.nums[i]!=nums[i-1]，遇到新元素，count重置。
            * 2.nums[i]==nums[i-1],与之前的相同
            *   2.1如果此时count<=2，则replace
            *   2.2如果count>2则只遍历不替代。
            * */
            if (nums[i]!=nums[i-1]){
                nums[replace]=nums[i];
                replace++;
                count=1;
            }else {
                if (count<2){
                    nums[replace]=nums[i];
                    replace++;
                    count++;
                }
            }

        }
        return replace;
    }

    public static void main(String[] args) {
        RemoveDup removeDup=new RemoveDup();
        int [] nums={1,1,1,2,2,2,3,4};
        removeDup.removeDuplicates(nums);
    }
}
