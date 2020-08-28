package _828;

import _726.Search;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/289:01
 */
//注意到每个矩阵左下角[右上角相对应]的元素有个特点，它对应的行的元素都比它大，它对应的列的元素都比它小。
    //如果当前的元素比target大，那么可缩小该矩阵即舍弃该行，如果当前的元素比target小，则需要舍弃这一列，缩小矩阵。
    //成功的情况:当前元素即为target返回。 找不到即跳出矩阵了。
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int column=0;
        while (row>=0&&column<matrix[0].length){
            if (matrix[row][column]==target){
                return true;
            }else if (matrix[row][column]<target){
                //往右
                column++;
            }else {
                //往上
                row--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix2 searchMatrix2=new SearchMatrix2();
        int [][]matrix= {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix2.searchMatrix(matrix, 20));
    }

}
