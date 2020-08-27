package _726;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/269:10
 */
public class DeleteDup {
    public ListNode deleteDuplicates(ListNode head) {
        /*
        * 引入头结点  统一化处理
        * 两个指针：
        * pre 与after
        * pre负责锁定需要删除的部分的pre。[因为删除需要知道pre]
        * after负责锁定 重复的最后一个节点。
        *
        * [pre.next=after.next]
        * */
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode after=head;
        while (after.next!=null){
            if (after.val!=after.next.val){
                pre=pre.next;
                after=after.next;

            }
            //需要删除 去锁定最后一个相等元素的位置  即after.val!=after.next.val
            else {
                while(after.next!=null&&after.val==after.next.val){
                    after=after.next;

                }
                pre.next=after.next;
                if (after.next!=null) {
                    after = after.next;
                }
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        //全相等无法处理
        DeleteDup deleteDup=new DeleteDup();
        ListNode l1= new ListNode(2);
        ListNode l2= new ListNode(2);
        ListNode l3= new ListNode(2);
        ListNode l4= new ListNode(2);
        ListNode l5= new ListNode(2);
        ListNode l6= new ListNode(2);
        ListNode l7= new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        ListNode head=deleteDup.deleteDuplicates(l1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
