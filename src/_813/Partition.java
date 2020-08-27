package _813;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/139:05
 */
//把一个字符串分割成若干个回文子串    求所有的分割方案 所有方案
// 先考虑回溯：需要的条件==》知道以某个元素为起始的所有的回文字符串。当知道以某个元素为起始的所有的回文串时，就逐个的进行递归
// 当一个字符串都结束了就添加到结果集中。通过一个动态规划进行预处理 找到所有的回文字符串[需要知道起始与末尾位置]
public class Partition {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        boolean[][] flag = findAllPalindromeSubstring(s);
        List<String> track = new ArrayList<>();
        backtrack(flag, s, track,0);
        return res;
    }
    //回溯找所有
    private void backtrack(boolean[][] flag, String s, List<String> track,int start) {
        //出口  求所有值
        if (start==s.length()){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=start;i<s.length();i++){
            if (flag[start][i]){
                track.add(s.substring(start, i+1));
                backtrack(flag, s, track, i+1);
                track.remove(track.size()-1);
            }
        }
    }

    //动态规划 找
    //状态转移方程：f(i,j)表示i->j是否为一个回文子串  f(i-1,j+1)=f(i,j)/\S[i-1]==S[j+1]
    private boolean[][] findAllPalindromeSubstring(String s) {
        char[] target = s.toCharArray();
        boolean[][] flag = new boolean[target.length][target.length];
        //初始化底
        for (int i = 0; i < target.length; i++) {
            flag[i][i] = true;
        }
        for (int i = 0; i < target.length - 1; i++) {
            if (target[i] == target[i + 1]) {
                flag[i][i + 1] = true;
            }
        }
        //迭代的填充整个flag
        //长度
        for (int i = 3; i <= target.length; i++) {
            for (int j = 0; j <= (target.length - i); j++) {
                int right=j+i-1;
                //i长度 j起始
                if (flag[j+1][right-1]&&(target[j]==target[right])){
                    flag[j][right]=true;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Partition partition=new Partition();
        partition.partition("aab");
    }
}
