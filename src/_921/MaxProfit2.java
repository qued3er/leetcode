package _921;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2111:28
 */
public class MaxProfit2 {
    /*
    * 求在这几天内该股票能达到的最大利润
    * 贪心算法：所有上升日我都持有
    *
    * */
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if (prices[i]-prices[i-1]>0){
                maxProfit+=(prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit2 maxProfit2=new MaxProfit2();
        int[]prices={7,1,5,3,6,4};
        System.out.println(maxProfit2.maxProfit(prices));
    }
}
