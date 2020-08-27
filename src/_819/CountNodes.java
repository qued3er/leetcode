package _819;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1911:27
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//首先使用递归法来计算完全二叉树的节点的个数
public class CountNodes {
    int number;
    public int countNodes(TreeNode root) {
        recursion(root);
        return number;
    }

    private void recursion(TreeNode root) {
        if (root==null){
            return;
        }
        recursion(root.left);
        number=number+1;
        recursion(root.right);
    }

}
