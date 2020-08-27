package _811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/118:38
 */
/*将中序遍历迭代化
* 通过栈：
* 如果当前节点有左子树，则应该将其左子树入栈，
* 若当前节点无左子树，则出栈一个元素，看其该元素是否有右子树，无继续出栈，有右子树入栈再进入1,2判断。*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        stack.addLast(root);
        while (!stack.isEmpty()){
            if (cur.left!=null){
                stack.addLast(cur.left);
                cur=cur.left;
            }else {
                TreeNode treeNode = stack.removeLast();
                res.add(treeNode.val);
                //找到第一个有右子树的
                while (treeNode.right==null){
                    if (stack.isEmpty()){
                        return res;
                    }
                    treeNode=stack.removeLast();
                    res.add(treeNode.val);
                }
                //出while是找到有右子树的了
                stack.addLast(treeNode.right);
                cur=treeNode.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        inorderTraversal inorderTraversal=new inorderTraversal();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        inorderTraversal.inorderTraversal(t1);
    }
}
