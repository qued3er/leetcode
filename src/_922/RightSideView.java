package _922;

import java.util.*;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/238:29
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 二叉树的右视图
 * 即从该二叉树的右边能看到的每一层的节点  从上到下   即求每一层的最右节点
 *
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return null;
        }
        List<Integer> result=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode cur=root;
        TreeNode last=root;
        queue.addLast(cur);
        while (!queue.isEmpty()){
            cur=queue.removeFirst();
            if (cur.left!=null){
                queue.addLast(cur.left);
            }
            if (cur.right!=null){
                queue.addLast(cur.right);
            }
            if (last==cur){
                result.add(cur.val);
                if (!queue.isEmpty()) {
                    last = queue.getLast();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t3.right=t5;
        RightSideView rightSideView=new RightSideView();
        rightSideView.rightSideView(t1);
    }
}
