package _918;

import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/1817:36
 */
public class MinStack {
    //通过两个数组来实现
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new LinkedList<>();
        minStack=new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        //当且x仅当比末尾的小时加入minstack
        if (minStack.isEmpty()){
            minStack.push(x);
        }
        if (x<minStack.getLast()){
            minStack.push(x);
        }
    }

    public void pop() {

    }

//    public int top() {
//
//    }
//
//    public int getMin() {
//
//    }
}
