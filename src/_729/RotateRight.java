package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/307:33
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }

}
/*k可能大于链表的长度*/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        int nodeNum=0;
        ListNode cur=head;
        while (cur!=null){
            nodeNum++;
            cur=cur.next;
        }
//        System.out.println(nodeNum);
        k=k%nodeNum;
        /*找到倒数第k个节点的前一个节点，然后逐个把它插入头部*/
        ListNode preKNode=findPreKNode(head,k);
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode curInsert=preHead;
        //开始逐个插入
        while(preKNode.next!=null){
            ListNode temp=preKNode.next;
            preKNode.next=temp.next;
            temp.next=curInsert.next;
            curInsert.next=temp;
            curInsert=curInsert.next;
        }
        return preHead.next;
    }

    private ListNode findPreKNode(ListNode head,int k) {
        int i=0;
        ListNode pre=head;
        ListNode after=head;
        //要有preNode，防止一共n个节点 去找倒数第n个节点的前驱
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        while (i<k){
            pre=pre.next;
            i++;
        }
        //一起走
        while (pre.next!=null){
            pre=pre.next;
            after=after.next;
        }
        return after;
    }
    public static ListNode getAList(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        return l1;
    }
    public static void main(String[] args) {
        RotateRight rotateRight=new RotateRight();
        ListNode head=rotateRight.rotateRight(RotateRight.getAList(),7);
        System.out.println(head.val);
    }
}
