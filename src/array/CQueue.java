package array;

import java.util.Stack;

public class CQueue {
    /*
两个栈，假设为s1和s2，
当需要append时，就直接将其压进栈s1
当需要delete时，先判断s2是否为空，若不为空，则直接从s2delete，若为空，则将s1的逐个出栈至s2.
*/
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.empty()==true&&s1.empty()==true){
            return -1;
        }else if(s2.empty()==true) {
            while (s1.empty() == false) {
                s2.push(s1.pop());
            }
        }
            return s2.pop();
    }
}
