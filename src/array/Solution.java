package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public int[] reversePrint(ListNode head) {
        /**
         从尾部到头部输出节点的值。 遍历链表逐个放入栈中，然后pop栈至Arraylist，然后转化为数组。
         */
        LinkedList<Integer> s1=new LinkedList<>();
        while(head.next!=null){
            s1.addLast(head.next.val);
        }
        int [] result=new int[s1.size()];
        int i=0;
        while (s1.isEmpty()==false){
            result[i]=s1.removeLast();
            i++;
        }
        return result;
    }
}
