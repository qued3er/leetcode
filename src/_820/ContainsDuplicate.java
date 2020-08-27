package _820;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2019:10
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //通过map key就是数字 value为出现次数  有2 即停止
        Map<Integer,Integer>dict=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (dict.containsKey(nums[i])){
                return false;
            }else {
                dict.put(nums[i],1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,1};
        ContainsDuplicate containsDuplicate=new ContainsDuplicate();
        containsDuplicate.containsDuplicate(nums);
    }
}
