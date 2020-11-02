package _828;

import _726.Search;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/288:26
 */
//leetcode 240.明显这道题的思路类似于二分法
    //从左到右升序 从上到下升序
    //错误的example   没看清题目
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix.length==1&&matrix[0].length==0){
            return false;
        }
        int left=0;
        int rightColumn=matrix[0].length-1;
        int right=matrix.length-1;
        //先锁定行  通过在最后一列使用二分法 找到第一个[important]大于target的。
        //结束时 right<left 且相邻
        while (left<=right){
            int mid=left+(right-left)/2;
            if (target>matrix[mid][rightColumn]){
                left=mid+1;
            }else if (target<matrix[mid][rightColumn]){
                right=mid-1;
            }
        }
        //再在这一行找有无target有返回true  无返回false
        return binarySearch(matrix[left],target);
    }

    private boolean binarySearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                return true;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }
//错误  没接起来  接起来可以这样
    public static void main(String[] args) {
        int [][]matrix= {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
        };
        SearchMatrix searchMatrix=new SearchMatrix();
        searchMatrix.searchMatrix(matrix, 5);
    }
}
