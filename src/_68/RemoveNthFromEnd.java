package _68;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/815:24
 */
// * Definition for singly-linked list
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 删除链表的倒数第n个节点并返回头结点
         * 删除一个节点必须知道其前驱节点，可以把链表转化为一个带头结点的链表统一化其他节点与第一个结点的操作。
         * 注意如果删除其最后一个节点，其没有next需要判断。
         * 通过三个指针来完成。
         */
        //统一化操作
        ListNode headPre=new ListNode(0);
        headPre.next=head;
        //找到倒数第n的节点及其前驱节点。
        ListNode lastN=head;
        ListNode lastNPre=headPre;
        ListNode current=head;
        for (int i = 0; i < n; i++) {
            current=current.next;
        }
        while(current!=null){
            current=current.next;
            lastN=lastN.next;
            lastNPre=lastNPre.next;
        }
        if(lastN.next!=null){
            lastNPre.next=lastN.next;
        }else {
            lastNPre.next=null;
        }
        return headPre.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd=new RemoveNthFromEnd();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        n1.next=n2;
        ListNode n3=new ListNode(3);
        n2.next=n3;
        ListNode n4=new ListNode(4);
        n3.next=n4;
        ListNode n5=new ListNode(5);
        n4.next=n5;
        n5.next=null;
        removeNthFromEnd.removeNthFromEnd(n1, 2);
    }
}
