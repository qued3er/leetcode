package _82;

import com.sun.scenario.effect.impl.state.AccessHelper;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/29:50
 */
public class IsValidSudoku {
    /**
     * 判重复首先想起来hash表，
     * 通过一个简化的表 boolean[10] 来做hash表，
     * 1的ascii 49
     *
     * 官方的解答使用的是空间换时间，即使用的不是一维数组，而是一个域board对应大小的二维数组来作为flag;
     * */
    boolean flag;
    public boolean isValidSudoku(char[][] board) {
        //判断每一行与每一列
        for (int i = 0; i < board.length; i++) {
            boolean []flagColumn=new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                int index=board[i][j]%49;
                if (flagColumn[index]){
                    return false;
                }else {
                    flagColumn[index]=true;
                }
            }
            boolean []flagRow=new boolean[9];
            for (int j = 0; j < board.length; j++) {
                int index=board[j][i]%49;
                if (flagRow[index]){
                    return false;
                }else {
                    flagRow[index]=true;
                }
            }
            //每一个方格 的start index
            //0,0  0,3  0,6
            //3,0  3,3  3,6
            //6,0  6,3  6,6

        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku=new IsValidSudoku();
        char [][] board={
                {}
        };
//        isValidSudoku.isValidSudoku();
    }
}
