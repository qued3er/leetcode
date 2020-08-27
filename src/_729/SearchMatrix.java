package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/297:58
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*左下或者右上搜索法
        每次判断基于上次判断

        从左下开始搜索
        */
        if (matrix.length==0||(matrix.length==1&&matrix[0].length==0)){
            return false;
        }
        for (int i=matrix.length-1;i>=0;i--){
            if (target>=matrix[i][0]){
                boolean flag=binarySearch(matrix[i],target);
                if (flag){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            int mid=(left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix=new SearchMatrix();
//        int [][] matrix={
//                {1,   3,  5,  7},
//        {10, 11, 16, 20},
//        {23, 30, 34, 50}};
        int [][]matrix={{}};
        System.out.println(searchMatrix.searchMatrix(matrix, 10));
    }
}
