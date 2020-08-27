package _87;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/78:24
 */
/*
* 使用动态规划：
* 考虑单词leetcode:如果我们要判断leetcode是否能拆分成字典中的多个单词，那么我们可以在l可以被拆分的情况下判断 eetcode是否在字典中
* 或者le可以被拆分的情况下判断etcode是否在字典中。....... leetcod可以被拆分的前提下e是否在字典中。
* 然后我们有需要判断基础：l,le,let,letc,letco....leetcod当做上述的leetcode继续划分。
* 这样就会有许多的重复计算：例如：l，le..是否可以被拆会被计算多次。那么我们通过一个表来记录下它是否就可以节省许多的计算时间。
* ===》所以我们需要记录的是l,le，..是否可以被拆分成字典中的单词。我们可以通过一个boolean类型的一维数组来保存。
* 这样我们就可以使用自顶向下[先查le是否被计算过，被计算过就不再计算]，或者自底向上[判断le基于l的结果，判断let基于l与le的结果..
* 后者的结果用前者的结果，所以先计算底之后逐步计算到整个单词]
*
* 经过上述分析之后我们可以得知我们的状态转移方程为:dp[i]=dp[j]&&wordDict.contains(s[j->i-1]),j∈[0,i-1],其中dp[i]表示前
* i个字符是否可以被拆分=》s子串下标范围为j->i-1. 且只要有一种拆分方法就代表可以被拆分，结束当前轮的判断。
*
* 底:判断第1个字符是否在workDict中。
*
* 为了提高查询子串速度，我们通过hash表来充足workList*/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<>(wordDict);
        boolean []dp=new boolean[s.length()+1];
        //对应情况 dict直接包含下标为0->i-1的字符==》与j=i对应的情况重复，所以不处理j=i
        dp[0]=true;
        dp[1]=dict.contains(s.substring(0, 1));
        for (int i=2;i<dp.length;i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&dict.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String>wordDict = new ArrayList<String>(){{
            add("leet");
            add("code");
        }
        };
        WordBreak wordBreak=new WordBreak();
        wordBreak.wordBreak(s, wordDict);
    }
}
