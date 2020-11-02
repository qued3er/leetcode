package _1028;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/10/289:39
 */

import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"

 */
public class DecodeString {
    //栈的特性：后进先出，越外层的越先进，后出，当满足

    //需要注意的点是[]可以嵌套，所以需要嵌套的进行解析。
    //重点在于括号===》通过栈来完成[先入后出]
    //即先入栈的后解析，对应于外层的括号解析晚于内层括号的解析。====》所以通过栈来完成
    //原始数据:字符串不包含数字。===》数字可能>1位
    public String decodeString(String s) {

        StringBuilder stack=new StringBuilder();
        StringBuilder repeatString=new StringBuilder();
        int repeatTimes=0;
        char[] target = s.toCharArray();
        for (Character c :
                target) {
            if (c.equals(']')){
                while (stack.length()!=0&&(stack.charAt(stack.length()-1)!=('['))){
                    repeatString.append(stack.charAt(stack.length()-1));
                    stack.deleteCharAt(stack.length()-1);
                }
                //去'['
                stack.deleteCharAt(stack.length()-1);
                int base=1;
                //确定重复次数
                while (stack.length()!=0&&(stack.charAt(stack.length()-1)>='0'&&stack.charAt(stack.length()-1)<='9')){
                    repeatTimes+=base*(stack.charAt(stack.length()-1)-48);
                    stack.deleteCharAt(stack.length()-1);
                    base=base*10;
                }

                //重复次数
                for (int i = 0; i < repeatTimes; i++) {
                    //把每个字符逆序插入
                    for (int j = repeatString.length()-1; j >=0 ; j--) {
                        stack.append(repeatString.charAt(j));
                    }
                }
                repeatString.delete(0, repeatString.length());
                repeatTimes=0;
            }else {
                stack.append(c);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString=new DecodeString();
        System.out.println(decodeString.decodeString("100[leetcode]"));
    }
}
