package _810;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1013:39
 */
/*有序链表转化为二叉平衡树
* 递归的构造:
* 链表转化为数组：基于数组构造 要好点
* 二分法[链表]划分当前子树的左右子树，递归构造左右子树。
* 递归出口：当前树只有一个节点。
* */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  /*
  * 用链表的二分法来做尝试：...............
  * */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>temp =new ArrayList<>();
        while (head!=null){
            temp.add(head.val);
        }
        Integer []sortArray=temp.toArray(new Integer[temp.size()]);
        if (sortArray.length==0){
            return null;
        }
        return buildTree(sortArray,0,sortArray.length-1);
    }

    private TreeNode buildTree(Integer[] sortArray, int left, int right) {
        if (left==right){
            return new TreeNode(sortArray[left]);
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(sortArray[mid]);
        //有左有右
        if (mid>left){
            TreeNode leftRoot=buildTree(sortArray, left, mid-1);
            root.left=leftRoot;
        }
        if (mid<right){
            TreeNode rightRoot=buildTree(sortArray,mid+1,right);
            root.right=rightRoot;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
