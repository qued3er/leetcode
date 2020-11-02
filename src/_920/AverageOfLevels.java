package _920;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2013:53
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        /*在层次遍历的过程中加入求和这个过程*/
        List<Double> res=new ArrayList<>();
        int nodeNumber=0;
        double val=0;
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode curr=root;
        TreeNode last=root;
        //尾入头出
        queue.addLast(curr);
        while (!queue.isEmpty()){
            curr = queue.removeFirst();
            nodeNumber++;
            val+=curr.val;
            if (curr.left!=null){
                queue.addLast(curr.left);
            }
            if (curr.right!=null){
                queue.addLast(curr.right);
            }
            if (curr==last){
                res.add(val/nodeNumber);
                val=0;
                nodeNumber=0;
                if (!queue.isEmpty()) {
                    last = queue.getLast();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AverageOfLevels averageOfLevels=new AverageOfLevels();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        System.out.println(averageOfLevels.averageOfLevels(t1));
    }
}
