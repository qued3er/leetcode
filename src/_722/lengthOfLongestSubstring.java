package _722;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2211:30
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        /*
        对比股票最大利益
        解法：
        motivation：先分别找以每个字符其实的最长子串，其中最长的即为最长子串。
        发现规律以前一个子串起始的最长子串为lk,那么以该字符的后一个字符起始的最长子串肯定包括
        lk减去第一个字符。
        implement：
        如何判断重复？
        通过hash表。
        hash表中存储的当前起始位置的不重复子串的字符。当我们向前进位时，就把头部移去，然后遍历后边
        看是否在hash表中。
        维持一个start一个end用来指示当前最长子串的起始与尾部
        */
        if (s.equals("")){
            return 0;
        }
        char[]target=s.toCharArray();
        HashSet<Character> set=new HashSet<>();
        int end=0;
        int longestLength=1;
        for(int i=0;i<target.length;i++){
            //返回的是以i起始的最长子串的end
            end=findLongestEnd(i,end,target,set);
            if(longestLength<set.size()){
                longestLength=set.size();
            }
            set.remove(target[i]);
        }
        return longestLength;
    }

    private int findLongestEnd(int start, int end, char[] target, HashSet<Character> set) {

//        set.remove(target[start-1]);
        for(int i=end;i<target.length;i++){
            if(set.contains(target[i])){
                end=i;
                break;
            }else {
                set.add(target[i]);
            }
        }
        return end;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring=new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("a"));
    }
}
