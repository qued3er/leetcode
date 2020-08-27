package _68;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/816:13
 */
public class IsValid {
    public boolean isValid(String s) {
        /**
         * 通过栈来判断，当目前读取到的为左括号时，就入栈，为右括号时，看栈顶是否为与之匹配的左括号，如果是，则出栈并
         * 下一个，如果不是直接return false
         * */
        char[] target=s.toCharArray();
        char[]stack=new char[target.length];
        if(target.length%2==1){
            return false;
        }
        int stackIndex=0;
        for (int i = 0; i < target.length; i++) {
            if(target[i]=='('||target[i]=='{'||target[i]=='['){
                stack[stackIndex]=target[i];
                stackIndex++;
            }else {
                if(target[i]==')'){
                    if(stackIndex==0||stack[stackIndex-1]!='('){
                        return false;
                    }else {
                        stackIndex--;
                    }
                }
                if(target[i]=='}'){
                    if(stackIndex==0||stack[stackIndex-1]!='{'){
                        return false;
                    }else {
                        stackIndex--;
                    }
                }
                if(target[i]==']'){
                    if(stackIndex==0||stack[stackIndex-1]!='['){
                        return false;
                    }else {
                        stackIndex--;
                    }
                }
            }
        }
        if (stackIndex==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsValid isValid=new IsValid();
        System.out.println(isValid.isValid("(()){[}"));
    }
}
