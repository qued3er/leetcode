package _820;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2019:47
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length==0||nums.length==1){
            return false;
        }
        Map<Integer,Integer> dict=new HashMap<>();
        int init=k;
        if (nums.length-1<k){
            init=nums.length-1;
        }
        //初始化0-k的节点
        for (int i=0;i<=init;i++){
            if (containsLessThanT(dict,t,i,nums)){
                return true;
            }
        }
        //初始化结束
        for (int i=init+1;i<nums.length;i++){
            //remove
            dict.remove(nums[i-k-1]);
            if (containsLessThanT(dict,t,i,nums)){
                return true;
            }
        }
        return false;
    }

    private boolean containsLessThanT(Map<Integer, Integer> dict, int t, int i, int[] nums) {
        //超出时间限制  应该是去逐个的遍历map中key去判断
        for (int value:
             dict.keySet()) {
            if (Math.abs((i-value))<=t){
                return true;
            }
        }
        dict.put(nums[i],i);
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate=new ContainsNearbyAlmostDuplicate();
        int []nums={1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
