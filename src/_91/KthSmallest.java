package _91;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/17:45
 */
/*方法1：有序数组的一轮归并排序[n路排序]=》找到第k个就结束。
* 方法2：二分法可以找到一个mid将整个矩阵划分为两个部分，左边部分全部比该mid小，右边全部比该mid大。 结束点 左边的区域仅剩下k个元素。
* 左右界限：左界限：matrix[0][0]  matrix[n-1][n-1]*/
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        /*int left=matrix[0][0];
        int right=matrix[matrix.length-1][matrix[0].length-1];
        int []leftArray=new int[matrix.length];
        int []rightArray=new int[matrix.length];
        for (int i=0;i<rightArray.length;i++){
            rightArray[i]=matrix.length-1;
        }
        int number=0;
        while (number!=k) {
            //对每一个行进行二分
            for (int i = 0; i < matrix.length; i++) {
                number += binarySearch(matrix, i, leftArray, rightArray);
            }
        }
        //
        int max=0;
        for (int i=0;i<rightArray.length;i++){

        }*/
        int []leftIndex=new int[matrix[0].length];
        int minRow=0;
        int minValue=Integer.MAX_VALUE;
        for (int j=k;j>0;j--) {
            if (leftIndex[minRow]==matrix[0].length){
                minRow++;
                j++;
                continue;
            }
            //n路归并排序
            for (int i = 0; i < matrix.length; i++) {
                if (leftIndex[i] == matrix[0].length) {
                    continue;
                }
                if (matrix[i][leftIndex[i]] <= matrix[minRow][leftIndex[minRow]]) {
                    minRow = i;
                    minValue=matrix[i][leftIndex[i]];
                }
            }
            leftIndex[minRow]++;
        }
        return minValue;
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest=new KthSmallest();
        int [][]matrix={{1,2},
                {1,3}};
        System.out.println(kthSmallest.kthSmallest(matrix, 4));
    }
}
