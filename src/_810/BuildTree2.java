package _810;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1013:02
 */
/*根据中序和后序遍历的顺序构造二叉树
* 递归的构造：
* 1.在后序中找到最后一个元素[根]，然后找到该根在中序中的位置。
* 2.分别找左子树与右子树的前序遍历的数组与中序遍历的数组，递归的构造左右子树。[注意：1.可能仅有右子树/仅有左子树  所以构造左右子树之前需要判断]
* */
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0){
            return null;
        }
        return buildSubTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildSubTree(int[] inorder, int inLeft, int inRight, int[] postorder, int posLeft, int posRight) {
        //递归结束点当前子树只剩下一个节点
        if (posLeft==posRight){
            return new TreeNode(postorder[posRight]);
        }
        //找左右子树的中序与后序遍历
        //方法：先找root在中序中的位置，然后 就可划分出左子树与右子树的中序。 然后可依此计算出左子树节点的个数。
        //然后去划分左右子树的后序遍历[根据左子树的节点个数就可划分出来]
        TreeNode root=new TreeNode(postorder[posRight]);
        int rootIndex=findRootInInorder(inorder,inLeft,inRight,postorder[posRight]);
        if (rootIndex==-1){
            throw  new RuntimeException("输入的前序和中序遍历顺序有误");
        }
        //正常的处理
        int leftTreeNodeNumber=rootIndex-inLeft;
        //左子树的后序 右索引
        int leftPostRight=posLeft+leftTreeNodeNumber-1;
        //根据中序判断有无左右子树
        if (rootIndex>inLeft){
            TreeNode leftRoot=buildSubTree(inorder, inLeft, rootIndex-1, postorder,posLeft, leftPostRight);
            root.left=leftRoot;
        }
        if (rootIndex<inRight){
            TreeNode rightRoot=buildSubTree(inorder, rootIndex+1, inRight, postorder,leftPostRight+1, posRight-1);
            root.right=rightRoot;
        }
        return root;
    }

    private int findRootInInorder(int[] inorder, int inLeft, int inRight, int val) {
        for (int i=inLeft;i<=inRight;i++){
            if (inorder[i]==val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BuildTree2 buildTree2=new BuildTree2();
        int []inorder = {9,3,15,20,7};
        int []postorder = {9,15,7,20,3};
        buildTree2.buildTree(inorder, postorder);
    }
}
