package _819;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1913:20
 */
/*使用二分查找来确定节点的个数
* 假设一共d层，先计算出前d-1层的节点个数，然后二分的去判断d层的节点个数，边界为1-2^(d-1)
* 如何二分的判断d层的节点个数，拿值验证。  找到中点，判断中点在d层是否存在，如果存在则left=中点
* 如果不存在 则right=中点-1
* 如何判断该节点在第d层是否存在？
* 假设当前要检测是否存在的节点在最后一层的为第idx个， 从根开始，如果我们往根的左子树走，表示idx<最后一层的节点的个数
* /2，往右子树走相对应。 然后我们把根的左子树或者右子树当做新根，最后一层为d-1,同样判断当前idx往左还是往右
* 可用二分迭代或者递归完成。*/
public class CountNode2 {
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        //一共多少层？
        int depth=1;
        TreeNode cur=root;
        while (cur.left!=null){
            depth++;
            cur=cur.left;
        }
        //满二叉树部分的节点个数。
        int full=(int) Math.pow(2, depth-1)-1;
//        System.out.println(full);
        //最后一层的节点个数
        int left=1;
        int right=(int)Math.pow(2, depth-1);
        while (left<=right){
            int mid=left+(right-left)/2;
            if (exist(mid,depth,root)){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return full+left-1;
    }

    private boolean exist(int idx, int depth, TreeNode root) {
        int left=1;
        int right=(int)Math.pow(2, depth-1);
        for (int i=0;i<depth-1;i++){
            int mid=left+(right-left)/2;
            //孩子节点个数是偶数 所以==往左。
            if (idx<=mid){
                root=root.left;
                //相当于去左子树  左子树的右界限就是mid
                right=mid;
            }else {
                root=root.right;
                //右子树的界限为mid+1
                left=mid+1;
            }
        }
        return root!=null;
    }

    public static void main(String[] args) {
        CountNode2 countNode2=new CountNode2();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        System.out.println(countNode2.countNodes(t1));
    }
}
