package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/298:51
 */
public class SetZero {
    public void setZeroes(int[][] matrix) {
        /* 原地算法：
            通过两次遍历，第一遍遍历把所有为0的数字设为
        */
        //0------>matrix.length-1 的flag标志着对应行是否要设为0  matrix.length------>matrix.length+matrix[0].length-1标记
        //对应列是否要设为0
        int [] flags=new int[matrix.length+matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    flags[i]=1;
                    flags[matrix.length+j]=1;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (flags[i]==1||flags[matrix.length+j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZero setZero=new SetZero();
        int [][]matrix={
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZero.setZeroes(matrix);
        System.out.println(1);
    }
}
