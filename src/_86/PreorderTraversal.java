package _86;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/613:27
 */
/*迭代的完成对一颗二叉树完成前序遍历[root left right]
* ****通过栈来存储已经遍历的根节点的顺序，然后当left为空时就去弹出它，然后访问其右[右也入栈]，再向左。*/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        if (root!=null){
            stack.addLast(root);
            res.add(root.val);
        }
        while (root.left!=null){
            root=root.left;
            stack.addLast(root);
            res.add(root.val);
        }
        while (!stack.isEmpty()){
            TreeNode curNode = stack.removeLast();
            if (curNode.right!=null) {
                curNode = curNode.right;
                while (curNode.left != null) {
                    stack.addLast(curNode);
                    res.add(curNode.val);
                    curNode = curNode.left;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        PreorderTraversal preorderTraversal=new PreorderTraversal();
        preorderTraversal.preorderTraversal(t1);
//        TreeNode t4=new TreeNode();
//        TreeNode t5=new TreeNode();
//        TreeNode t6=new TreeNode();

    }
}
