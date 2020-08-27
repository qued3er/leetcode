package _810;

import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/107:51
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
/*使用层次遍历，保存前驱，每下降一层就要初始化一个前驱节点，如何记录其层次？*/
public class Connect {
//    int level;
    public Node connect(Node root) {
        LinkedList<Node> queue=new LinkedList<>();
//        Node last=root;
        Node pre=new Node();
        queue.addLast(root);
        while (!queue.isEmpty()){
            Node node = queue.removeFirst();
            //遍历
            pre.next=node;
            pre=node;
            //入其孩子
            if (node.left!=null) {
                queue.addLast(node.left);
            }
            if (node.right!=null) {
                queue.addLast(node.right);
            }
//            if (node==last){
//                level++;
//                last=queue.getLast();
//            }
        }
        //把每一层的最右节点的next置为空
        Node cur=root;
        while (cur.right!=null){
            cur.next=null;
            cur=cur.right;
        }
        return root;
    }
    public static void main(String[] args) {
        Connect connect=new Connect();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        connect.connect(n1);
    }
}
