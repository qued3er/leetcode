package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2214:18
 */
public class GameOfLife {
    // 1周围有2-3个1 存活 其他死亡   0 周围 3个1 复活。
//细胞的出生和死亡是同时发生的   当我这个位置改为1  不能用于 别的位置的判断。
    //通过一个同样大小的额外的数组来存储其下一个状态 以免影响到别的判断
    public void gameOfLife(int[][] board) {
        int [][]flags=new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                ensureStatus(i,j,flags,board);
            }
        }
        //更新board
//        for (int i=0;i<board.length;i++){
//            for (int j=0;j<board[0].length;j++){
//                board[i][j]=flags[i][j];
//            }
//        }
//        board=flags;
//        int [][]newborad=board;
    }

    private void ensureStatus(int row, int column, int[][] flags, int[][] board) {
        int aliveNumber=0;
        //左右
        //有上[左上 右上 上]
        if (row>0){
            aliveNumber+=board[row-1][column];
            if (column>0){
                aliveNumber+=board[row-1][column-1];
            }
            if (column<board[0].length-1){
                aliveNumber+=board[row-1][column+1];
            }
        }
        //有下[左下 右下 下]
        if (row<board.length-1){
            aliveNumber+=board[row+1][column];
            if (column>0){
                aliveNumber+=board[row+1][column-1];
            }
            if (column<board[0].length-1){
                aliveNumber+=board[row+1][column+1];
            }
        }
        //左右
        if (column>0){
            aliveNumber+=board[row][column-1];
        }
        if (column<board[0].length-1){
            aliveNumber+=board[row][column+1];
        }
        if (board[row][column]==0){
            if (aliveNumber==3){
                flags[row][column]=1;
            }
        }else {
            if (aliveNumber>=2&&aliveNumber<=3){
                flags[row][column]=1;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife=new GameOfLife();
        int[][]board={{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        gameOfLife.gameOfLife(board);

    }
}
