package _813;

import sun.dc.pr.PRError;

import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1310:36
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
/*对一个链表进行排序  要求：时间复杂度O(nlgn)
* 空间复杂度：常数量级
* 首先对链表进行划分===》划分要二分  快慢指针
* 然后使用归并排序去排序有序链表的归并
* 分治法： 划分子问题   对子问题进行合并
* */
public class SortList {
    public ListNode sortList(ListNode head) {
        //递归出口 仅有一个元素
        if (head!=null&&head.next==null){
            return head;
        }
        //分治划分
        ListNode mid=divide(head);
        ListNode l1=sortList(head);
        ListNode l2=sortList(mid);
        //结果集合并=====>应该对返回的头部 的两个头结点进行merge
        head=merge(l1,l2);
        return head;
    }
    //两个有序链表的合并 ===》没有加入哨兵节点  所以对第一个元素没有进行处理********
    private ListNode merge(ListNode l1, ListNode l2) {
        //l2逐个插入l1中
        //sentry节点
        ListNode sentry=new ListNode(-1);
        sentry.next=l1;
        ListNode cur=sentry;
        while (l2!=null){
            //找到当前l2节点要插入的位置,插入到第一个比它大的元素前
            //仅有一个元素的对比  没比较就跳过了l1 5     l2 -1
            //最后一个元素没有对比大小
            while (cur.next!=null){
                //第一个比它大的元素前
                if(cur.next.val>l2.val){
                    break;
                }
                cur=cur.next;
            }
            //结束是因为cur遍历完了 需要进行尾处理
            if (cur.next==null){
                break;
            }
            //正常插入
            ListNode insertNode=l2;
            l2=l2.next;
            insertNode.next=cur.next;
            cur.next=insertNode;
        }
        //后处理
        if (l2!=null){
            cur.next=l2;
        }
        return sentry.next;
    }

    //快慢指针找mid
    private ListNode divide(ListNode head) {
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode slow=preHead;
        ListNode fast=preHead;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //断开
        ListNode res=slow.next;
        slow.next=null;
        return res;
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
//        ListNode l1=new ListNode();
        SortList sortList=new SortList();
        ListNode head=sortList.sortList(l1);
        //丢了个0节点
        System.out.println("====================");
    }
}
