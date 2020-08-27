package _730;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3011:26
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
         * 通过4个index来指示本次正方形的边界。
         * 每次遍历都从i,i开始
         * columnStart：起始行
         * columnEnd:结束行
         * rowStart:起始列
         * rowEnd:结束列
         * */
        List<Integer> res=new ArrayList<>();
        int columnStart=0;
        int columnEnd=matrix.length-1;
        int rowStart=0;
        int rowEnd=matrix[0].length-1;
        while (columnStart<=columnEnd&&rowStart<=rowEnd){
            //从左向右
            for (int i=rowStart;i<=rowEnd;i++){
                res.add(matrix[columnStart][i]);
                if (i==rowEnd){
                    columnStart++;
                }
            }
            if (columnStart>columnEnd){
                break;
            }
//            columnStart++;
            for (int i=columnStart;i<=columnEnd;i++){
                res.add(matrix[i][rowEnd]);
                if (i==columnEnd){
                    rowEnd--;
                }
            }
            if (rowStart>rowEnd){
                break;
            }
            //必须要for 执行了才能rowEnd--
//            rowEnd--;
            for (int i = rowEnd; i >=rowStart ; i--) {
                res.add(matrix[columnEnd][i]);
                if (rowStart==i){
                    columnEnd--;
                }
            }
            if (columnStart>columnEnd){
                break;
            }
//            columnEnd--;
            for (int i=columnEnd;i>=columnStart;i--){
                res.add(matrix[i][rowStart]);
                if (columnStart==i){
                    rowStart++;
                }
            }
            if (rowStart>rowEnd){
                break;
            }
//            rowStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]matrix={
            { 1, 2, 3 ,4 },
            { 5, 6 ,7 ,8},
            { 9, 10 ,11,12 }
        };
        SpiralOrder spiralOrder=new SpiralOrder();
        spiralOrder.spiralOrder(matrix);
    }
}
