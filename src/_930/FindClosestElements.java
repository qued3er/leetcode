package _930;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/308:50
 */
//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
// 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //通过双指针法来实现该算法，首先找到x，确定双指针的位置，然后 向左右扩散至k为0  List用LinkList方便前插后插。
        LinkedList<Integer> res=new LinkedList<>();
        int index=binarySearch(arr,x);
        int left=index;
        int right=index+1;
        while (k>0) {
            if (left>=0&&right<arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(x-arr[right])) {
                    res.addFirst(arr[left]);
                    left--;
                } else {
                    res.addLast(arr[right]);
                    right++;
                }
            }else if (left>=0){
                res.addFirst(arr[left]);
                left--;
            }else{
                res.addLast(arr[right]);
                right++;
            }
            k--;
        }
        return res;
    }

    private int binarySearch(int[] arr,int x) {
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (arr[mid]==x){
                return mid;
            }
            if (arr[mid]<x){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[]arr={1,3};
        FindClosestElements findClosestElements=new FindClosestElements();
//        System.out.println(findClosestElements.binarySearch(arr, 3));
        findClosestElements.findClosestElements(arr, 1, 2);
    }
}
