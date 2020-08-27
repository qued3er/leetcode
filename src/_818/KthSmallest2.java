package _818;

import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/189:14
 */
//迭代法去完成找二叉搜索树的第k个节点  迭代法优势  便于停止
public class KthSmallest2 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode>stack=new LinkedList<>();
        stack.addLast(root);
        while (stack!=null){
            if (root.left!=null){
                stack.addLast(root.left);
                root=root.left;
            }else {
                TreeNode node = stack.removeLast();
                k--;
                if (k==0){
                    return node.val;
                }
                if (node.right!=null){
                    stack.addLast(node.right);
                    root=node.right;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        KthSmallest2 kthSmallest2=new KthSmallest2();
        kthSmallest2.kthSmallest(t1, 3);
    }
}
