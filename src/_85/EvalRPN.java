package _85;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/518:08
 */
public class EvalRPN {
    /*通过栈来实现
    * 遇到数字就入栈，入到符号就出栈两个数字做运算并将结果压入栈*/
    public int evalRPN(String[] tokens) {
        Set<String>opTable=new HashSet<String>(){
            {
                add("+");
                add("-");
                add("*");
                add("/");
            }
        };
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (opTable.contains(tokens[i])){
                int opNumber2=stack.removeLast();
                int opNumber1=stack.removeLast();
                int res=0;
                switch (tokens[i]){
                    case "+" :res=opNumber1+opNumber2;break;
                    case "-" :res=opNumber1-opNumber2;break;
                    case "*" :res=opNumber1*opNumber2;break;
                    case "/" :res=opNumber1/opNumber2;

                }
                stack.addLast(res);
            }else {
                stack.addLast(Integer.parseInt(tokens[i]));
            }
        }
        return stack.removeLast();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN=new EvalRPN();
        String[]tokens={"2","1","+","3","*"};
        evalRPN.evalRPN(tokens);
    }
}
