package _818;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/188:44
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  //寻找二叉搜索树的第k小节点的值
//对于一个二叉搜索树  它的中序遍历的顺序是按照有序排序的序列。
//使用一个全局变量，每中序到一个节点，就对该值加1，为k时返回。
public class KthSmallest {
    int sequence;
    int res;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        //元素个数大于1
        inOrder(root,k);
        return res;
    }

      private void inOrder(TreeNode root, int k) {
          if (root==null){
              return;
          }
          if (!flag) {
              inOrder(root.left, k);
          }
          sequence++;
          if (sequence==k){
              res=root.val;
              flag=true;
          }
          if (!flag) {
              inOrder(root.right, k);
          }
      }

  }
