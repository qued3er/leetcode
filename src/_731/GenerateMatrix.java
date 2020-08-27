package _731;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/317:58
 */
public class GenerateMatrix {
    /**
     * 顺时针打印1-n*/
    public int[][] generateMatrix(int n) {
        /*
        * */
        int [][]res=new int[n][n];
        int i=1;
        int columnStart=0;
        int rowStart=0;
        int columnEnd=n-1;
        int rowEnd=n-1;
        while (rowStart<=rowEnd&&columnStart<=columnEnd){
            //从左往右
            for (int j = rowStart; j <= rowEnd; j++) {
                res[columnStart][j]=i;
                i++;
                if (j==rowEnd){
                    columnStart++;
                }
            }
            if (columnStart>columnEnd){
                break;
            }
            //从上到下
            for (int j = columnStart; j <= columnEnd; j++) {
                res[j][rowEnd]=i;
                i++;
                if (j==columnEnd){
                    rowEnd--;
                }
            }
            if (rowStart>rowEnd){
                break;
            }
            //从右到左
            for (int j = rowEnd; j >= rowStart; j--) {
                res[columnEnd][j]=i;
                i++;
                if (j==rowStart){
                    columnEnd--;
                }
            }
            if (columnStart>columnEnd){
                break;
            }
            //从下到上
            for (int j = columnEnd; j >= columnStart; j--) {
                res[j][rowStart]=i;
                i++;
                if (j==columnStart){
                    rowStart++;
                }
            }
            if (rowStart>rowEnd){
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix=new GenerateMatrix();
        generateMatrix.generateMatrix(4);
    }
}
