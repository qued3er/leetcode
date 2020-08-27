package _82;

import java.util.*;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/38:31
 */
public class GroupAnagrams {
    /*对字符数组排序，排序后如果.equals相等 则相等*/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> set=new HashMap<>();
        for (String s :
                strs) {
            String sortedString=sortString(s);
            if (set.containsKey(sortedString)){
                set.get(sortedString).add(s);
            }else {
                List<String> sortValue=new ArrayList<>();
                sortValue.add(s);
                set.put(sortedString,sortValue);
            }
        }
        List<List<String>> res=new ArrayList<>();
        res.addAll(set.values());
        return res;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println('e'+'a'+'t');
        System.out.println('a'+'t'+'e');
    }
}
