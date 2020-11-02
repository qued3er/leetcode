package _91;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/28:42
 */
/*nums1 = [1,7,11], nums2 = [2,4,6], k = 3
* 自己的想法：维护一个数组，来记录第一个数组的每个元素该与第二个数组的哪个元素结合。 每次比较得到最小他在数组的对应的index应该
* +1.这样的时间复杂度是O(kn)  可以改为O(klgn)通过堆。*/
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>res=new ArrayList<>();
        int [] index=new int[nums1.length];
        for (int i=k;i>=0;i--) {
            int min=0;
            for (int j = 0; j < nums1.length; j++) {
                //对比取最小
                if ((nums1[j]+nums2[index[i]])<min){
                    
                }
            }
        }
        return res;
    }
}
