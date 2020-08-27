package _816;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1611:46
 */
//动态规划
    //转移方程:假设dp[n]表示吃掉n个橘子需要的天数，
    // 那么dp[n]=dp[1/3n]+1  n是3的倍数   dp[n]=dp[1/2n]+1 n是2的倍数
    //dp[n]=dp[n-1]+1 n既不是2的倍数也不是3的倍数

    //上述思路错误   思路应该为：
    //若要到达当前的dp[n],可以是从dp[n-1]+1来，也可以是dp[(1/2)n]+1+n%2【吃到2的倍数，再到(1/2)n】,也可以是
    //dp[(1/3)n]+1+n%3[先吃到3的倍数，再吃(2/3)n]
    //之前的思路出在什么地方？
    //如果我们当前求的是dp[n]且n是3的倍数，那么就一定是dp[(1/3)n]+1最小吗？===》不一定，这种猜想需要基于我们的dp数组
// 是递增的，那么我们减的越多  剩下的越少，那么需要的总的就越少。===》但是dp数组真的是递增吗？
    //dp[1]=1 dp[2]=2 dp[3]=2 dp[4]=3 dp[4]=3 dp[5]=4 dp[6]=3  ===>不是  所以上述是错的 我们应该做的是在所有可能到来的路径
    //求最小值
    //但是这样从底向上计算会超内存===》原因：当需要计算的n很大的时候，由于空间复杂度是跟着n上升的，所以我们需要优化空间复杂度
    //如何优化？==》数组堆溢出    注意到：并不需要计算从1->n的所有dp，只需要部分的dp，所以我们可以使用map，仅把需要的部分put进map中
    //递归+记忆化
public class MinDays {
    /*public int minDays(int n) {
        int []dp=new int[n+1];
        //dp[n]代表吃掉n个橘子需要的天数
        dp[1]=1;
        if (n==1){
            return dp[1];
        }
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i/2]+1+i%2,Math.min(dp[i-1]+1,dp[i/3]+1+i%3));
        }
        return dp[n];
    }*/
    //橘子个数：天数
    Map<Integer,Integer> cache=new HashMap<>();
    MinDays(){
        cache.put(1, 1);
        cache.put(2, 2);
    }
    public int minDays(int n) {
        if (n==1){
            return 1;
        }
        if (cache.containsKey(n)){
            return cache.get(n);
        }
//        int res=Math.min(Math.min(minDays(n-1),minDays(n/2)+n%2+1),minDays(n/3)+1+n%3);
        //把第一个计算剔除了  即一个一个吃 因为其他两种必<=它  所以可以把它剔除了
        int res=Math.min(minDays(n/2)+n%2+1, minDays(n/3)+1+n%3);
        cache.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        MinDays minDays=new MinDays();
        System.out.println(minDays.minDays(61455274));
    }
}
