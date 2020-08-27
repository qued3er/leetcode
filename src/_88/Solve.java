package _88;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/810:41
 */
public class Solve {
    /*首先找到与边界相邻的所有的O，并把其改为k，然后遍历二维数组，把所有的O改为X，把K改为O*/
    public void solve(char[][] board) {
        findAndTagNotChangeO(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='K'){
                    board[i][j]='O';
                }
            }
        }
    }
    //通过DFS
    private void findAndTagNotChangeO(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i]=='O'){
                dfs(board,0,i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0]=='O'){
                dfs(board,i,0);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length-1][i]=='O'){
                dfs(board,board.length-1,i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length-1]=='O'){
                dfs(board,i,board[0].length-1);
            }
        }
    }
    //把边界相邻的所有O都变为K
    private void dfs(char[][] board, int column, int row) {
        board[column][row]='K';
        //左，若存在
        if (row>0&&board[column][row-1]=='O'){
            dfs(board, column, row-1);
        }
        //右，若存在
        if (row<board[0].length-1&&board[column][row+1]=='O'){
            dfs(board, column, row+1);
        }
        //上，若存在
        if (column>0&&board[column-1][row]=='O'){
            dfs(board, column-1, row);
        }
        //下，若存在
        if (column<board.length-1&&board[column+1][row]=='O'){
            dfs(board, column+1, row);
        }
    }

    public static void main(String[] args) {
        char[][]board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solve solve=new Solve();
        solve.solve(board);
        System.out.println("=============================");
    }
}
