package _930;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/308:28
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 //二叉树的根是数组中的最大元素。
 //左子树是通过数组中最大值左边部分构造出的最大二叉树。
 //右子树是通过数组中最大值右边部分构造出的最大二叉树。
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

     private TreeNode construct(int[] nums, int start, int end) {
        if (start>end){
            return null;
        }
        int max=findMax(nums,start,end);
        TreeNode root=new TreeNode(nums[max]);
        root.left=construct(nums,start, max-1);
        root.right=construct(nums,max+1,end);
        return root;
     }
    //找最大元素
     private int findMax(int[] nums, int start, int end) {
        int max=start;
        for (int i=start+1;i<=end;i++){
            if (nums[i]>nums[max]){
                max=i;
            }
         }
        return max;
     }

     public static void main(String[] args) {
         ConstructMaximumBinaryTree constructMaximumBinaryTree=new ConstructMaximumBinaryTree();
         int []nums={3,2,1,6,0,5};
         TreeNode root=constructMaximumBinaryTree.constructMaximumBinaryTree(nums);
         System.out.println(1);
     }
 }
