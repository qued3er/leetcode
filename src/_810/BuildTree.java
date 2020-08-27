package _810;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1010:54
 */
/*根据前中序的遍历顺序构造二叉树,首先前序与中序的特点：前序：root left right 中序:left root right，所以我们拿前序遍历中的第一个
个元素，在中序中找到他的位置，可划分出该root的左右子树，然后根据左子树的元素个数可划分出前序中的左子树与右子树的位置。
递归的构造每颗树的左右子树，方法返回当前子树的根。*/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //小心0-（1）
        if (preorder.length==0){
            return null;
        }
        return buildSubTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    //可能会无左子树或者右子树，需要加判断
    private TreeNode buildSubTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        //递归出口
        if (preLeft==preRight){
            return new TreeNode(preorder[preLeft]);
        }
        //拿当前前序的第一个值构造一个节点
        TreeNode root=new TreeNode(preorder[preLeft]);
        //寻找递归的构造left与right[找left与right边界] 默认能找到    其实可以加入判断 使得程序更健壮
        int rootIndex=findRootInInorder(preorder[preLeft],inorder,inLeft,inRight);
        //需要考虑 无左或者无右   根据inorder找到的root判断  无左：rootIndex==inLeft  无右：rootIndex=inright
        int leftNodeNumber=rootIndex-inLeft;
//        int rightNodeNumber=inRight=rootIndex;
        int leftPreRight=preLeft+leftNodeNumber;
        if (rootIndex>inLeft) {
            TreeNode leftRoot = buildSubTree(preorder, preLeft + 1, leftPreRight, inorder, inLeft, rootIndex - 1);
            root.left=leftRoot;
        }
        if (rootIndex<inRight) {
            TreeNode rightRoot = buildSubTree(preorder, leftPreRight + 1, preRight, inorder, rootIndex + 1, inRight);
            root.right=rightRoot;
        }
        return root;

    }
    //无序查找
    private int findRootInInorder(int rootVal, int[] inorder, int inLeft, int inRight) {
        //传过来的inRight是坐标而不是长度
        for (int i = inLeft; i <=inRight ; i++) {
            if (inorder[i]==rootVal){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []preorder = {1,2};
        int []inorder = {2,1};
        BuildTree buildTree=new BuildTree();
        TreeNode root=buildTree.buildTree(preorder, inorder);
        System.out.println("===========");
    }
}
