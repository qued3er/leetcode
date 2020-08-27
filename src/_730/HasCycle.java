package _730;



/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3016:23
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class HasCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = hasCycle(head);
        if (slow==null){
            return null;
        }else {
            ListNode after=head;
            slow=slow.next;
            while (after!=slow){
                after=after.next;
                slow=slow.next;
            }
            return after;
        }
    }
    public ListNode hasCycle(ListNode head) {
        /*
        快慢指针:
        两个指针同时走，一个一次走两步，一个一次走一步，若有环，快指针先入环，慢指针后入环，经过若干步骤后两者会相遇。
        */
        if (head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        //判断是否有环
        while (slow!=fast){
            if (slow.next==null||fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        HasCycle hasCycle=new HasCycle();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(0);
//        ListNode l4=new ListNode(-4);
        l1.next=l2;
        l2.next=l1;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l2;
        System.out.println(hasCycle.detectCycle(l1).val);
    }
}
