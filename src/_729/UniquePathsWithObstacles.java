package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2920:04
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        int [][]record=new int[obstacleGrid.length][obstacleGrid[0].length];
        //只有一行和只有一列的特殊情况

        //初始化所有的最后一行和最后一列
        //设0的方式有问题，当最后一行或者最后一列某一个元素为0时，那么其前的每一个元素都应该设为0.
        //最后一列
        for (int i = obstacleGrid.length-1; i >=0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length-1]==0){
                record[i][obstacleGrid[0].length-1]=1;
            }else {
                break;
            }
        }
        //最后一行
        for (int i = obstacleGrid[0].length-1; i >=0; i--) {
            if (obstacleGrid[obstacleGrid.length-1][i]==0){
                record[obstacleGrid.length-1][i]=1;
            }else {
                break;
            }
        }
//        record[obstacleGrid.length][obstacleGrid[0].length]=0;
        for (int i=obstacleGrid.length-2;i>=0;i--){
            for (int j=obstacleGrid[0].length-2;j>=0;j--){
                if (obstacleGrid[i][j]==1){
                    record[i][j]=0;
                }else {
                    record[i][j]=record[i+1][j]+record[i][j+1];
                }
            }
        }
        return record[0][0];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles=new UniquePathsWithObstacles();
        int [][]o={{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(o));
    }
}
