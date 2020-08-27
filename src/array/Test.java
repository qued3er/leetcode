package array;

public class Test {
    public ListNode getKthFromEnd(ListNode head, int k) {
        /*双指针法：
        维持两个指针，当before指针到达k的时候behind开始与其同步运动，当before到达链表尾部的时候，behind所指向的就是倒数第K个节点
        */
        //考虑特殊情况，k<0


        ListNode before = head;
        int i = 1;
        ListNode current = head;
        //让先节点先走k
        while (i < k) {
            //考虑两边的长度小于k的情况
            if (current.next == null) {
                break;
            }
            before = current.next;
            i++;
        }
        if (i != k) {
            return null;
        }

        ListNode behind = head;
        //开始同步走
        while (before.next != null) {
            before = before.next;
            behind = behind.next;
        }
        return behind;
    }
}


