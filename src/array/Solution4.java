package array;

public class Solution4 {
    /*采用回溯法：暴力法升级版

找到与word第一个字母相同的所有字母的位置，然后从这个位置开始。
先创建一个域 board大小向的二维数组类型的（0，未，1已），来记录是否遍历过该数组

开始位置：首先记录从这个地方可以通过一步可以到达的且未使用过的地方，然后逐个判断这个位置是否符合要求（与第i个字符的位置是否对应，对应则继续递归查询剩下的，若不符合，则换其他未使用过的地方，若所有的地方都试过且都不符合要求。返回上一级的为使用的地方。）
*/
    public boolean exist(char[][] board, String word) {
        //起始点  从第一个开始，调用方法的传入参数，当前相邻的元素
        boolean [][] flag=new boolean[board.length][board[0].length];
//        是否被调用过的装态
        char [] target=word.toCharArray();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(match(board,i,j, target,0,flag)==true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean match(char [][]board,int line,int row,char []target,int k,boolean[][] flag){
        //边界处理，且判断第一个字符是否match。
        if(line<0||line>board.length-1||row<0||row>board[0].length-1||target[k]!=board[line][row]) {
        return false;
        }
        //把匹配的点对应的位置设为true，表示该节点已经使用过。
        flag[line][row]=true;
        //表示前length-2个都匹配了，且通过了上一个if，第length-1个也匹配了
        if(k==target.length-1){
            return true;
        }
        //越过数组边界的再第一个if就被拦下，不会到这儿
//        if(flag[line-1][row]){
//            boolean tag1=match(board, line-1, row, target,k+1,flag);
//        }
//        if(flag[line+1][row]){
//            boolean tag2=match(board, line+1, row, target,k+1,flag);
//        }
//        if(flag[line][row-1]){
//            boolean tag1=match(board, line, row-1, target,k+1,flag);
//        }
//        if(flag[line][row+1]){
//            boolean tag1=match(board, line, row+1, target,k+1,flag);
//        }

        boolean tag=(match(board, line-1, row, target,k+1,flag)||match(board, line+1, row, target,k+1,flag)
            ||match(board, line, row-1, target,k+1,flag)||match(board, line, row+1, target,k+1,flag));
        return tag;
    }
}