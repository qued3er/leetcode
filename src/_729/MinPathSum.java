package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2920:58
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        /*动态规划*/
        int row=grid.length;
        int column=grid[0].length;
        int [][] res=new int[row][column];
        res[row-1][column-1]=grid[row-1][column-1];
        for(int i=row-2;i>=0;i--){
            res[i][column-1]=res[i+1][column-1]+grid[i][column-1];
        }
        for(int i=column-2;i>=0;i--){
            res[row-1][i]=res[row-1][i+1]+grid[row-1][i];
        }
        for(int i=row-2;i>=0;i--){
            for(int j=column-2;j>=0;j--){
                int max=res[i+1][j]<res[i][j+1]?res[i+1][j]:res[i][j+1];
                res[i][j]=max+grid[i][j];
            }
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        int [][]grid={{1,3,1},
                {1,5,1},
                {4,2,1}
};
        MinPathSum minPathSum=new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
