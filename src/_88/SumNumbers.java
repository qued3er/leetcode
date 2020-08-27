package _88;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/89:56
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class SumNumbers {
    int res;
    /*需要记录其所有的父节点,属于DFS的一种吧*/
    public int sumNumbers(TreeNode root) {
        int curSum=0;
        dfs(root,curSum);
        return res;
    }

    private void dfs(TreeNode root, int curSum) {
        if (root.left==null&&root.right==null){
            res=res+curSum*10+root.val;
            return;
        }
        curSum=curSum*10+root.val;
        if (root.left!=null)dfs(root.left, curSum);
        if (root.right!=null)dfs(root.right, curSum);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(0);
        TreeNode t2=new TreeNode(1);
//        TreeNode t3=new TreeNode(3);
        t1.left=t2;
//        t1.right=t3;
        SumNumbers sumNumbers=new SumNumbers();
        sumNumbers.sumNumbers(t1);
    }
}
