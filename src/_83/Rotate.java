package _83;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/316:24
 */
public class Rotate {
    /*原地完成顺时针90度旋转
    * 结果是：
    * 最后一行变成了第一列
    * 倒数第二行编程了对应的第二列
    * ...
    *
    * 但是直接使用在原地交换会导致覆盖
    * 所以采用以下算法：
    * 1.最后一行一第一列交换
    * 2.经过1的交换后把第1行与最后一行交换，这样就缩小了需要交换的矩阵
    *
    * ===》使用递归
    * */
    /*
    * 顺时针旋转：先按照副对角线 对称  然后 按照水平中线对称
    * */
    public void rotate(int[][] matrix) {
        //按照副对角线对称
        for (int i = matrix.length-1; i >=0; i--) {
            for (int j = 0; j <matrix[0].length-1-i ; j++) {
                exchange(matrix,i,j);
            }
        }
        //按照中线对称一下
        for (int i=0;i<matrix.length/2;i++){
            for (int j=0;j<matrix[0].length;j++){
                exchange2(matrix,i,j);
            }
        }
    }

    private void exchange2(int[][] matrix, int column, int row) {
        int temp=matrix[column][row];
        matrix[column][row]=matrix[matrix.length-1-column][row];
        matrix[matrix.length-1-column][row]=temp;
    }

    private void exchange(int[][] matrix, int column, int row) {
        int temp=matrix[column][row];
        matrix[column][row]=matrix[matrix.length-1-row][matrix.length-1-column];
        matrix[matrix.length-1-row][matrix.length-1-column]=temp;

    }

    public static void main(String[] args) {
        int [][]matrix={
                {1,2,3},
                {4,5,6},
        {7,8,9}};
        int [][]matrix2={
        { 5, 1, 9,11},
        { 2, 4, 8,10},
        {13, 3, 6, 7},
        {15,14,12,16}
    };
        Rotate rotate=new Rotate();
        rotate.rotate(matrix2);
        System.out.println("res");
    }
}
