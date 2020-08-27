package _813;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/13 7:49
 */
/*如果通过暴力迭代：就是找以每个元素起始的子串，然后比较最长。 如何找以某个元素起始的不重复子串，每新加一个字符串就与该元素为起始
* 所有字符相比较[hash表==》预分配长度  s的长度]，无重复继续以该元素为起始判断下一个元素，有重复则以上个重复元素元素的下一个元素为起始
* 再一轮进行判断。需要维护的是1.最长长度longestLength，2当前长度curLength 3.当前子串的起始位置for i
* 4.当前元素的当前位置 for j 5.重复时的位置  为了下次从这儿继续匹配[优化]6.HashMap[优化 不用逐个对比]7.早退出[优化：j到字符串末尾
* curlength只能再减小了，可以直接返回]
*
* */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        //Key:value = 元素 :下标
        HashMap<Character,Integer>dict=new HashMap<>(s.length());
        //节省内存
        char[] target = s.toCharArray();
        int curLength=0;
        int longestLength=0;
        int newj=0;
        //子串起始位置
        for (int i = 0; i <target.length ; i++) {
            //子串当前位置
            for (int j = newj; j < target.length; j++) {
                //重复了   不需要继续判断 break 跳出
                if (dict.containsKey(target[j])){
                    //把字典中从起始位置到重复位置的所有元素都删除，然后从之前重复的哪个元素之后匹配
                    int dupIndex=dict.get(target[j]);
                    //删除从起始位置 i到 dupIndex的所有元素
                    for (int idx=dupIndex;idx>=i;idx--){
                        dict.remove(target[idx]);
                    }
                    //新i=dupindex+1[交给i++] 新j还是该重复位置
                    i=dupIndex;
                    newj=j;

                    break;
                }
                //未重复
                else {
                    dict.put(target[j],j);
                    curLength++;
                    //早退出
                    if(j==target.length-1){
                        return Math.max(curLength, longestLength);
                    }
                }
            }
            //一次不重复子串匹配结束
            if (curLength>longestLength){
                longestLength=curLength;
            }
            //当前length=两个重复元素之间的元素个数i 为之前重复的位置 newj=之后重复位置
            curLength=newj-i-1;
        }
        return longestLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring=new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
    }
}
