package _727;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2710:52
 */
public class Exist {
    //需要   添加flag 剪枝  对比
    public boolean exist(char[][] board, String word) {
        /*
        只要有一条路径为真 就可以返回 true  所有的为false 才能返回false。
         */
        int [][]flags=new int[board.length][board[0].length];
        char[] target = word.toCharArray();
        //先去找所有以首字母开始的位置。
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==target[0]){
                    boolean flag=search(board,flags ,i,j,target,1);
                    if (flag==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int[][] flags, int row, int column,char[]target,int index) {
        flags[row][column]=1;
        if (index==target.length){
            return true;
        }
        boolean flag1=false,flag2=false,flag3=false,flag4=false;
        //往左
        if (column>0&&flags[row][column-1]==0&&board[row][column-1]==target[index]){
            flag1=search(board, flags, row, column-1, target, index+1);
        }
        //往右
        if (column<board[0].length-1&&flags[row][column+1]==0&&board[row][column+1]==target[index]){
            flag2=search(board, flags, row, column+1, target, index+1);
        }
        //往上
        if (row>0&&flags[row-1][column]==0&&board[row-1][column]==target[index]){
            flag3=search(board, flags, row-1, column, target, index+1);
        }
        //往下
        if (row<board.length-1&&flags[row+1][column]==0&&board[row+1][column]==target[index]){
            flag4=search(board, flags, row+1, column, target, index+1);
        }
        flags[row][column]=0;
        return flag1||flag2||flag3||flag4;
    } 


    public static void main(String[] args) {
        char [][] target={
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        Exist exist=new Exist();
        System.out.println(exist.exist(target, "AAB"));
    }
}
