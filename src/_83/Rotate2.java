package _83;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/317:44
 */
public class Rotate2 {
    /*解法2：
    * 有length/2个正方形，对正方形进行90度的旋转
    * */
    public void rotate(int[][] matrix) {
        int column=matrix.length;
        int row=matrix[0].length;
        for (int i = 0; i < matrix .length/ 2; i++) {
            //旋转正方形
            for(int j=i;j<matrix[0].length-1-i;j++){
                exchange(matrix,i,j);
            }
        }
    }

    private void exchange(int[][] matrix, int column, int row) {
        int temp=matrix[column][row];
//        matrix[column][row]=matrix[][];
    }
}
