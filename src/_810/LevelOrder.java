package _810;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/108:59
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  /*通过设置一个last来实现
  * */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeNode last=root;
        LinkedList <TreeNode>queue=new LinkedList<>();
        List<Integer>commonLevel=new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            //遍历该node
            commonLevel.add(node.val);
            //添加其左右节点
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }
            if (node==last){
                res.add(commonLevel);
                commonLevel=new ArrayList<>();
                if (!queue.isEmpty()) {
                    last = queue.getLast();
                }
            }
        }
        return res;
    }

      public static void main(String[] args) {
          LevelOrder levelOrder=new LevelOrder();
          TreeNode t1=new TreeNode(3);
          TreeNode t2=new TreeNode(9);
          TreeNode t3=new TreeNode(20);
          TreeNode t4=new TreeNode(15);
          TreeNode t5=new TreeNode(7);
          t1.left=t2;
          t1.right=t3;
          t3.left=t4;
          t3.right=t5;
          levelOrder.levelOrder(t1);
      }
}
