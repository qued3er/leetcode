package _921;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2110:01
 */
public class MaxProfit {
    /*
    * 求买卖股票可获得的最大利润
    * [7,1,5,3,6,4]
    * 以7结尾的为0  以1结尾的为0  以5结尾的为4 以 3结尾的为2 以6结尾的为5 以4结尾的为3
    * 暴力是O(n2)
    * 状态转移方程：profit[i]表示的是以price[i]结尾的最大的利润  那么则有状态转移方程profit[i]=max(profit[i-1],price[i]-i之前最小价格)
    * */
    public int maxProfit(int[] prices) {
        /*
        * 状态转移方程：profit[i]表示的是以price[i]结尾的最大的利润  那么则有状态转移方程profit[i]=max(profit[i-1],price[i]-i之前最小价格)
        *
        * 考虑：为什么我们在使用动态规划的时候总是使用方法：以i结尾的，而不是以i开头的，这是由于动态规划的方法的本质，动态规划要求
        * 之后的结果 是基于其之前的结果做决定的。 所以我们是使用以i结尾的来描述动态转移方程 而不是以i起始的。  从而从短逐渐向长结果过度
        * */
        int min=prices[0];
        int maxProfit=0;
        for (int price:
             prices) {
            min=Math.min(min, price);
            maxProfit=Math.max(maxProfit, price-min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit=new MaxProfit();
        int[]prices={7,1,5,3,6,4};
        System.out.println(maxProfit.maxProfit(prices));
    }
}
