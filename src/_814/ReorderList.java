package _814;

import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/147:48
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*整体思路先对后一半元素进行翻转，然后维持两个指针进行插入时间复杂度O(n),空间复杂度O(1)。
* 翻转：找到中间元素的前驱元素，维持一个尾指针，把元素逐个的插入尾部即完成后半部分节点的旋转
* 插入：维持两个指针，同步走把后边指向的元素插入到前边元素的后边。
* */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null||(head!=null&&head.next==null)){
            return;
        }
        //顺便要返回一个尾指针
        ListNode midPre=fingMidPre(head);
        //首先找到尾部。根据返回的midePre，如何判断我已经reverse完毕了 根据原尾部节点判断
        reverseList(midPre);
        //逐个插入
        insertNode(head,midPre);
        System.out.println(head);
    }

    private void insertNode(ListNode head, ListNode midPre) {
        ListNode cur=head;
        while (midPre.next!=null){
            //最后一个节点要特殊处理
            if (midPre.next.next!=null) {
                ListNode insertNode = midPre.next;
                midPre.next = midPre.next.next;
                insertNode.next = cur.next;
                cur.next = insertNode;
                cur = cur.next.next;
            }//相当于是最后一个节点  直接处理
            //偶数个节点 相当于已经插入  奇数个节点
            else {
                //如何区分奇偶
                if (midPre==cur) {
                    break;
                }else {
                    ListNode insertNode=midPre.next;
                    midPre.next=null;
                    insertNode.next=cur.next;
                    cur.next=insertNode;
                }
            }
        }
    }
//reverse  把midPre之後的节点逐个插入到当前尾部[应该是尾部不用动逐个插入到尾部]
    //逆转链表是逐个把前边的节点插入尾部节点去   尾部节点不用动。
    private void reverseList(ListNode midPre) {
        //找到尾部节点【并不是midPre就是curRear】
        ListNode curRear=midPre;
        while (curRear.next!=null){
            curRear=curRear.next;
        }
        while (midPre.next!=curRear){
            if (curRear.next==null){
                ListNode insertNode=midPre.next;
                midPre.next=midPre.next.next;
                insertNode.next=null;
                curRear.next=insertNode;
            }else {
                ListNode insertNode=midPre.next;
                midPre.next=midPre.next.next;
                insertNode.next=curRear.next;
                curRear.next=insertNode;
            }
        }
    }

    private ListNode fingMidPre(ListNode head) {
        //通过快慢指针
         ListNode headPre=new ListNode(-1);
         headPre.next=head;
         ListNode slow=headPre;
         ListNode fast=headPre;
         //偶数个节点 刚好是中间节点的前驱
        //奇数个节点  也是中间节点的前驱
         while (fast.next!=null&&fast.next.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         if (fast.next==null){
             return slow;
         }else {
             return slow.next;
         }
    }

    public static void main(String[] args) {
        ReorderList reorderList=new ReorderList();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l7=new ListNode(7);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        reorderList.reorderList(l1);
    }
}
