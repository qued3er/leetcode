package _731;

import javax.management.ListenerNotFoundException;
import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3119:33
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*按照层次产生这棵树
        先产生头结点  再逐层的产生新节点并连接
        完全二叉树一定是平衡二叉树*/
        if (nums.length==0){
            return null;
        }
        TreeNode root=new TreeNode(nums[0]);
        /*通过一个队列*/
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        for (int i=1;i<nums.length/2;i++){
            TreeNode node = queue.removeFirst();
            TreeNode left=new TreeNode(nums[2*i-1]);
            node.left=left;
            queue.addLast(left);
            TreeNode right=new TreeNode(nums[2*i]);
            node.right=right;
            queue.addLast(right);
        }
        //奇数个节点还剩2个节点
        //偶数个节点还剩1个节点
        if(nums.length%2==0){
            TreeNode node = queue.removeFirst();
            TreeNode left=new TreeNode(nums[nums.length-1]);
            node.left=left;
        }else {
            TreeNode node = queue.removeFirst();
            TreeNode left=new TreeNode(nums[nums.length-2]);
            node.left=left;
            queue.addLast(left);
            TreeNode right=new TreeNode(nums[nums.length-1]);
            node.right=right;
            queue.addLast(right);
        }
        return root;
    }
}
