package _820;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/20 8:08
 */
//很容易想到动态规划[以i,j为正方形右下角的正方形的最大边长取决于其上、左上、左的正方形的最小边长+自身]
    //如果某个元素为0，那么以他为右下角肯定形不成正方形
    //如果某个元素为1，那么以他为右下角元素的正方形取决于它的左，上，左上元素[为右下]的最大正方形的边长+1。
    //转化为状态转移方程为：dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1],[j-1])+1
    //底为第一行与第一列的：
// 因为某个点基于其左 左上与 上。   不用初始化其值就代表了其自己。
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int [][]dp=new int [matrix.length][matrix[0].length];
        //初始化第一行与第一列
        for (int i=0;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i];
        }
        for (int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0];
        }
        //初始化所有边长为1的正方形
        for (int i=1;i<matrix.length;i++){
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]=='0'){
                    dp[i][j]='0';
                }
                //当当前元素为1的时候 需要根据其左.上.左上来判断当前的能不能扩大。
                else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        //找到最大的边长   返回其面积
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return (max-48)*(max-48);
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare=new MaximalSquare();
        char [][]matrix={{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
