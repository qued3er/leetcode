package array;

import java.util.Hashtable;

public class Solution1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            /** 运用分治法。
                 前序遍历：根 左子树  右子树
                 中序遍历：左子树  根  右子树
                          root  lefttreenode  righttreenode
                          lefttreenode root righttreenode
                1.先在前序遍历中找到根节点，然后根据找到的根节点的值在中序遍历中（假设其下标i）找到中序遍历左右子树的边界，
             然后根据左右子树节点的个数（i-start）又可以找到左右子树在前序遍历中的边界
                2.根据这样就可以得到左右子树在前序遍历以及中序遍历的边界，从而递归调用
                3.如何确定结束条件，若该子树还有节点则有：leftindex<=rightindex，若大于则不用处理。
             */
            //由于需要在中序遍历中不断的根据value寻找根节点的index，所以将中序遍历的value：index存储至hashtable中去。
            Hashtable<Integer,Integer> h1=new Hashtable<>();
            for(int i=0;i<inorder.length;i++){
                h1.put(inorder[i],i);
            }
            TreeNode root=buildTree(preorder, 0, preorder.length-1, inorder
            , 0, inorder.length-1,h1);

            return root;
        }
        //考虑为什么要加入参数start与end？
        public TreeNode buildTree(int[]preorder,int presta,int preend,int[] inorder,int insta,int inend,
                                  Hashtable<Integer,Integer> h1){
            if (presta > preend) {
                return null;
            }
            TreeNode root=new TreeNode(preorder[0]);
            //中序遍历根的下标
            int rootIndex=h1.get(preorder[0]);
            int leftNodeNumber=rootIndex-insta;
            int rightNodeNumber=inend-rootIndex;
            TreeNode leftNodeRoot=buildTree(preorder, presta+1,
                    presta+leftNodeNumber, inorder, insta, rootIndex-1, h1);
            TreeNode rightNodeRoot=buildTree(preorder, presta+leftNodeNumber+1,
                    preend, inorder, rootIndex+1, inend, h1);

            root.left=leftNodeRoot;
            root.right=rightNodeRoot;
            return root;

        }
    }
}
