package _86;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/613:26
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class preorderTraversal1 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
