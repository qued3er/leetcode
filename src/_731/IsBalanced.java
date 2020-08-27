package _731;

import _68.IsValid;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3119:10
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        /*平衡二叉树是递归定义的*/
        if (root==null){
            return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&(getDepth(root.left)-getDepth(root.right)>=-1&&
                getDepth(root.left)-getDepth(root.right)<=1);
    }

    private int getDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDep=getDepth(root.left);
        int rightDep=getDepth(root.right);
        return Math.max(leftDep, rightDep)+1;
    }
    public static void main(String[] args) {
        IsBalanced isBalanced =new IsBalanced();

    }
}
