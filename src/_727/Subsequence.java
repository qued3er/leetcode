package _727;

import _527.Subsets;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2714:27
 */
public class Subsequence {
    public boolean isSubsequence(String s, String t) {
        /**
         * 使用动态规划进行预处理：
         * motivation：我们在使用暴力解法的时候，会用大量的时间来查找下一个匹配的字符。 如果我们对其进行预处理：即用f[i][j]来表
         * 示 从t[i]开始，之后 j字符首次出现的位置。[j实现字符到数字的映射]。a 映射到 0 b 映射到1
         * 如果我们又f[i][j]这个表，那么我们就可以跳转去寻找是否有对应字符串。[且对于一个库进行多次查找 效率特别高。]
         * 如何构建该数组？
         * f[i][j]=i,if t[i]=j。t[i]处是j对应的字符。
         * f[i][j]=f[i+1][j], t[i]!=j t[i]处不是j对应的字符。
         * 构建的顺序：列不变，行从后往前。
         * 底f[i][j] t[i]==j  f[i][j]=i;
         * a = 97
         * */

        char[]subset=s.toCharArray();
        char[] target=t.toCharArray();
        //
        int [][] indexSet=new int[target.length][26];
        //确定底
        return true;

    }

    public static void main(String[] args) {
        Subsequence subsequence=new Subsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
    }
}
