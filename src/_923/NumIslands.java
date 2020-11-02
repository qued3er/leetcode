package _923;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2216:42
 */
public class NumIslands {
    /**
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * 你可以假设该网格的四条边均被水包围。
     * 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * 这是三个岛屿
     * 什么时候岛屿的数量+1 发现一个1 开始扩张 扩张完毕 +1
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int gridNumber=0;
        for (int i=0;i<grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    //开始扩展岛屿  把对应1的地方变为'3'
                    replace(i,j,grid);
                    gridNumber++;
                }
            }
        }
        return gridNumber;
    }
    //把该1扩展的所以1变为3
    private void replace(int row, int column, char[][] grid) {
        //把其水平和数值方向上的'1'改为'3'
        grid[row][column]='3';
        //上 需要首先判断动了会不会越界
        if (row>0&&grid[row-1][column]=='1'){
            replace(row-1, column, grid);
        }
        //下
        if (row<grid.length-1&&grid[row+1][column]=='1'){
            replace(row+1, column, grid);
        }
        //左
        if (column>0&&grid[row][column-1]=='1'){
            replace(row, column-1, grid);
        }
        //右
        if (column<grid[0].length-1&&grid[row][column+1]=='1'){
            replace(row, column+1, grid);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands=new NumIslands();
        char[][]grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands.numIslands(grid));
    }
}
