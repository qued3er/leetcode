package _922;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/23 9:21
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class OddEvenList {
    /**
     * 给定一个链表把位置为奇数的节点放一块，位置为偶数的节点放一块。
     * 1->2->3->4
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode();
        ListNode even=new ListNode();
        ListNode cur=head;
        ListNode oddCur=odd;
        ListNode evenCur=even;
        int index=1;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=null;
            if (index%2==1) {
                oddCur.next = cur;
                oddCur = oddCur.next;
            }else {
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            index++;
            cur=next;
        }
        oddCur.next=even.next;
        return odd.next;
    }
    public static ListNode arrayToList(int []array){
        ListNode head=new ListNode();
        ListNode cur=head;
        for (int i :
                array) {
            ListNode node=new ListNode(i);
            cur.next=node;
            cur=node;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = arrayToList(new int[]{1, 2, 3, 4, 5});
        OddEvenList oddEvenList=new OddEvenList();
        oddEvenList.oddEvenList(head.next);
    }
}
