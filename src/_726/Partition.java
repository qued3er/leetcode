package _726;

import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/260:24
 */
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Partition {
    public ListNode partition(ListNode head, int x) {
        /* 把head中的节点根据x移到两个链表中，然后对两个链表进行合并。
        * 为了统一化处理，引入头结点。【对头与非头处理统一化】
        *
        * */
        ListNode large=new ListNode(0);
        //保留头结点位置  为了合并
        ListNode largeHead=large;
        ListNode less=new ListNode(0);
        ListNode lessHead=less;
        while (head!=null){
            ListNode cur=head;
            head=head.next;
            if (cur.val<=x){
                less.next=cur;
                less=less.next;
                less.next=null;
            }else {
                large.next=cur;
                large=large.next;
                large.next=null;
            }
        }
        less.next=largeHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        Partition partition=new Partition();
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(4);
        ListNode l3= new ListNode(3);
        ListNode l4= new ListNode(2);
        ListNode l5= new ListNode(5);
        ListNode l6= new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        ListNode head=partition.partition(l1, 3);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
