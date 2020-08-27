package _819;

import java.util.LinkedList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/197:51
 */
/*中缀表达式的计算器
字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格
1.中缀转后缀
2.两个栈[符号与数字]
* */
public class Calculate {
    LinkedList<Character> stack=new LinkedList<>();
    public int calculate(String s) {
        char[] target = s.toCharArray();

        for (int i = 0; i < target.length; i++) {
            switch (target[i]){
                case '+':{
                    stack.addLast(target[i]);
                }
                case '-':{
                    stack.addLast(target[i]);
                }
                case '(':{
                    stack.addLast(target[i]);
                }
                case ')':{
                    //出栈计算至最近的一个左括号
                    while (stack.getLast()!='('){
                        Character opNum1 = stack.removeLast();
                        Character op = stack.removeLast();
                        Character opNum2 = stack.removeLast();

                    }
                }
                case ' ':{
                    break;
                }
                default:{
                    stack.addLast(target[i]);
                }
            }
        }
        return 1;
    }
}
