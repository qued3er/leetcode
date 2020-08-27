package _820;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2019:21
 */
//更新index   通过map  key为nums[i] value 为其index
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer>dict=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (dict.containsKey(nums[i])){
                Integer pre = dict.get(nums[i]);
                if (i-pre<=k){
                    return true;
                }
            }
            dict.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate=new ContainsNearbyDuplicate();
        int []nums={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums, 2));
    }
}
