package _810;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/109:54
 */
/*锯齿形层次遍历
* 即上一层从左往右则这一层从右往左
* 当前层从左往右遍历则先添加做节点，后添加右节点，下层节点在队列中从左向右摆放
* 当前层从右向左遍历，则先添加右再添加左，下层节点在队列中从右向左摆放[队头到队尾]
* 两者下层均从队尾到队头【即拿数据都是从右向左拿，添加都往左部分添加】==》区别就在于添加顺序*/
public class ZigzagLevelOrder {
    private static final int LEFT_TO_RIGHT=0;
    private static final int RIGHT_TO_LEFT=1;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //结果列表
        List<List<Integer>>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        //0 从左往右  1从右往左
        int order=LEFT_TO_RIGHT;
        //当前层的最右节点
        TreeNode last=root;
        //当前层的所有节点值
        List<Integer>commonLevel=new ArrayList<>();
        //队列
        LinkedList<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
//            if (order==LEFT_TO_RIGHT) {
//                TreeNode node = queue.removeLast();
//            }else {
//                TreeNode node = queue.removeFirst();
//            }
            TreeNode node =(order==LEFT_TO_RIGHT)?queue.removeLast():queue.removeFirst();
            //遍历
            commonLevel.add(node.val);
            if (order==LEFT_TO_RIGHT){
                if (node.left!=null){
                    queue.addFirst(node.left);
                }
                if (node.right!=null){
                    queue.addFirst(node.right);
                }
            }else {
                if (node.right!=null){
                    queue.addLast(node.right);
                }
                if (node.left!=null){
                    queue.addLast(node.left);
                }
            }
            //判断是否该进下一层
            if (node==last){
                res.add(commonLevel);
                commonLevel=new ArrayList<>();
                if (!queue.isEmpty()) {
                    last = (order==LEFT_TO_RIGHT)?queue.getLast():queue.getFirst();
                }
                //更改下一层的顺序
                order=(order==LEFT_TO_RIGHT)?RIGHT_TO_LEFT:LEFT_TO_RIGHT;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder=new ZigzagLevelOrder();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.right=t5;
        zigzagLevelOrder.zigzagLevelOrder(t1);
    }
}
