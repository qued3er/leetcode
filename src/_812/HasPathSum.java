package _812;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/127:48
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
//DFS
public class HasPathSum {
    boolean flag;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        hasPathSumNoneNull(root,sum);
        return flag;
    }

    private void hasPathSumNoneNull(TreeNode root, int sum) {
        sum=sum-root.val;
        if (sum==0&&root.left==null&&root.right==null){
            flag=true;
        }
        //会有负值
//        if (sum<0){
//            return;
//        }
        if (!flag&&root.left!=null){
            hasPathSumNoneNull(root.left, sum);
        }
        if (!flag&&root.right!=null){
            hasPathSumNoneNull(root.right, sum);
        }
    }


    public static void main(String[] args) {
        HasPathSum hasPathSum=new HasPathSum();
        TreeNode n1=new TreeNode(-2);
        TreeNode n2=new TreeNode(4);
//        TreeNode n3=new TreeNode(8);
//        TreeNode n4=new TreeNode(11);
//        TreeNode n5=new TreeNode(13);
//        TreeNode n6=new TreeNode(4);
//        TreeNode n7=new TreeNode(7);
//        TreeNode n8=new TreeNode(2);
//        TreeNode n9=new TreeNode(1);
        n1.left=n2;
//        n1.right=n3;
//        n2.left=n4;
//        n3.left=n5;
//        n3.right=n6;
//        n4.left=n7;
//        n4.right=n8;
//        n6.right=n9;
        System.out.println(hasPathSum.hasPathSum(n1, 22));
    }
}
