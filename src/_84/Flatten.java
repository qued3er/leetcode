package _84;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/411:41
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
public class Flatten {
    TreeNode pre=new TreeNode();
    public void flatten(TreeNode root) {
        /*
         *1遍按照遍历顺序将root的left串起来  1遍去右指针  */
        modifyLeft(root);
        removeRight(root);
        leftToRight(root);
    }

    private void leftToRight(TreeNode root) {
        while (root!=null){
            root.right=root.left;
            root.left=null;
            root=root.right;
        }
    }

    private void removeRight(TreeNode root) {
        if (root==null){
            return;
        }
        root.right=null;
        removeRight(root.left);
        removeRight(root.right);
    }

    private void modifyLeft( TreeNode root) {
        if (root==null){
            return;
        }
        pre.left=root;
        pre=root;
        modifyLeft(root.left);
        modifyLeft(root.right);
    }

    public static void main(String[] args) {
        Flatten flatten=new Flatten();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t5=new TreeNode(5);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t6=new TreeNode(6);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t3.right=t4;
        t5.right=t6;
        flatten.flatten(t1);
    }
}
