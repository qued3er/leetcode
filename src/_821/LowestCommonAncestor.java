package _821;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/218:22
 */
//寻找两个节点的最近公共祖先
// 两种方法1、递归法  如何判断一个节点是不是p/q的公共祖先？ 先不说深度最大的，设fl表示 左子树包含p/q，fr表示右子树
//包含p/q  那么可以描述为：(fl&&fr)||(root=p&&(fl||fr)||(root=q&&(fl||fr))) 可描述为：左右子树分在当前根的
//左右两侧，或者当前根为p/q且q/p在其左或右子树中。
// 2、先找两个节点的祖先路径存下来并找到分叉点或者找到p/q。
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        //左右均无p,q且当前根不为p/q 返回null
        if (left==null&&right==null){
            return null;
        }
        //左无p,q, 右有 且根不为p/q
        if (left==null){
            return right;
        }
        //右无p,q，且左右 且根不为p/q。
        if (right==null){
            return left;
        }
        //左含p,q且右含p,q返回根
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor=new LowestCommonAncestor();
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(2);
        TreeNode t6=new TreeNode(0);
        TreeNode t7=new TreeNode(8);
        TreeNode t8=new TreeNode(7);
        TreeNode t9=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t5.left=t8;
        t5.right=t9;
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(t1, t2, t3).val);
    }
}
