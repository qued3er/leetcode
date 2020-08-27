package _530;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/308:40
 */
public class PermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        /**
         * 判断给定的字符串是否为某个回文串的排列组合
         *
         * 解法： 如果该字符串时某个回文串的排列组合，那么只会有两种情况
         * 1：所有的字符均出现偶数次
         * 2.仅有一个字符出现奇数次
         *
         * 补充知识点[未用到]：
         * 异或的性质：
         * 1.异或运算满足交换律、结合律。
         * 2.对于任何数x，都有x^x=0，x^0=x。
         * 3.字符在进行数字运算的时候，把他当做他的ASCII来处理
         *
         * 解法：使用HashSet，每来一个字符，判断其是否能成功添加至HashSet里，如果可以，则加入，如果不可以，即已经有了
         * ，则将原来的移除，最后判断HashSet的size是否<=1。
         *
         * HashSet也可以使用 Boolean [] flag=new Boolean[128];===》针对ASCII
         * */
        Set<Character> container=new HashSet<>();
        for (char c:
             s.toCharArray()) {
            if(!container.add(c)){
                container.remove(c);
            }
        }
        if(container.size()<=1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutePalindrome permutePalindrome=new PermutePalindrome();
        System.out.println(permutePalindrome.canPermutePalindrome("aab"));
    }
}
