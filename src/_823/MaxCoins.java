package _823;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executor;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2314:47
 */
public class MaxCoins {

    public int maxCoins(int[] piles) {
    //每次选出最大次大和最小 次大之和即为自己可得最大  贪心算法
        Arrays.sort(piles);
        int sum=0;
        int start=piles.length-2;
        for (int i=1;i<=(piles.length/3);i++){
            sum+=piles[start];
            start=start-2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int x=100;
        int y=100;
        Integer a =200;
        Integer b=200;
        System.out.println(a==b);
    }
}
