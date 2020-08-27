package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 用hashmap实现
 */
public class TwoSum {
    public int climbStairs(int n) {
        int[] results = new int[n+1];
        results[0]=0;
        results[1]=1;
        results[2]=2;
        for (int i = 3; i <=n; i++) {
           results[i]=results[i-1]+results[i-2];
        }
        return results[n];
    }
}
