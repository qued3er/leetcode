package _86;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/68:57
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class InsertionSortList {
    /*对链表进行插入排序：
    * 1.在插入当前节点要记录下一个节点的位置
    * 2.从前往后找插入的位置
    * 3.加入头结点统一操作*/
    public ListNode insertionSortList(ListNode head) {
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        //记录当前要找插入位置的节点
        ListNode cur=preHead;
        //记录寻找插入节点的位置
        ListNode find=preHead;
        //插入的节点为cur.next因为 我们要删除该节点且成链所以要知道其前驱
        while (cur.next!=null){
            //找到插入位置的前驱
            ListNode insertPre=findInsertPre(cur,preHead);
            //插入or后移？
            if (insertPre.next==cur.next){
                cur=cur.next;
            }else {
                insertNode(insertPre,cur);
            }
        }
        return preHead.next;
    }
    //insertNode，插入位置的前驱，cur，要插入节点的前驱
    private void insertNode(ListNode insertPre, ListNode cur) {
        ListNode temp=cur.next;
        cur.next=temp.next;
        //插入
        temp.next=insertPre.next;
        insertPre.next=temp;
    }
    //要插入的节点是cur.next,找到第一个比他大的前驱。
    private ListNode findInsertPre(ListNode cur,ListNode preHead) {
        while (preHead.next!=cur.next){
            if (cur.next.val<=preHead.next.val){
                break;
            }
            preHead=preHead.next;
        }
        return preHead;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(-1);
        ListNode l2=new ListNode(5);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(0);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        InsertionSortList insertionSortList=new InsertionSortList();
        insertionSortList.insertionSortList(l1);
    }
}
