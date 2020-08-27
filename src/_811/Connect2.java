package _811;

import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/117:33
 */
// Definition for a Node.
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
//做完去尝试 链表二分法 生成二叉平衡树
//非完全二叉树：填充右侧指针
public class Connect2 {
    public Node connect2(Node root) {
        LinkedList<Node>queue=new LinkedList<>();
        Node pre=new Node();
        Node preNode=pre;
        queue.addLast(root);
        Node last=root;
        while (!queue.isEmpty()){
            Node node = queue.removeFirst();
            preNode.next=node;
            preNode=node;
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }
            if (node==last){
                //照顾最后一行
                if (!queue.isEmpty()) {
                    last = queue.getLast();
                }
                node.next=null;
                preNode=pre;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
//        Node n7=new Node(7);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
//        n2.right=n5;
        n3.right=n5;
//        Connect2 connect2=new Connect2();
//        connect2.connect2(n1);
        Connect3 connect3=new Connect3();
        connect3.connect3(n1);
        System.out.println("=================================");
    }
}
