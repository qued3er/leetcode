package _530;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/308:36
 */
public class LongestPalindrome {
    private  int start;
    private int end;
//    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    public String longestPalindrome(String s) {
        /**
         * 回文串的特点：如果一个字符串是回文串，那么其掐头去尾之后仍然是回文串。
         * 即如果一个字符子串是回文串且其左方和右方的字符相等，那么加上左右之后仍然为回文串。
         *
         * 动态规划：
         * 1.描述优解的结构特征。
         *          如果一个字符串是回文串，那么其掐头去尾之后仍然是回文串。
         * 2.递归的定义最优解值，
         *          F[i][j]表示字符串下标从i到j的是否为回文串。
         *          F[i][j]=F[i+1][j-1]^S[i]==S[j]
         * 3.自底向上的计算出最优解值，
         *          定义出底，长度为1的一定是回文串，长度为2如果两个字符相等也为回文串
         * 4，根据最优解值的信息，构造最优解
         *
        */
        char [] target=s.toCharArray();
        boolean [][]flag=new boolean[target.length][target.length];
        //初始化 flag数组 长度为1的  flag[i][i]==true  底如果仅仅为1  仅能扩展为长度为奇数的字符串序列
        for(int i=0;i<target.length;i++){
            flag[i][i]=true;
        }
        //初始化长度为2
        for(int i=0;i<target.length-1;i++){
            if(target[i]==target[i+1]){
                flag[i][i+1]=true;
            }else {
                flag[i][i+1]=false;
            }
        }
        //递归的定义最优解值
        //长度
        for(int i=3;i<=target.length;i++){
            //注意：扩展到了边界
            //该长度的所有可能
            for(int j=0;j<=target.length-i;j++){
                //当前是要判断 flag[j][j+i-1]的
//                if(j>0&&(j+i-1)<target.length-1){
                    if(flag[j+1][j+i-2]==true&&target[j]==target[j+i-1]){
                        flag[j][j+i-1]=true;
                    }
//                }
            }
        }
        //遍历该数组找最长的回文子串
//        从右上角斜着开始遍历
        for(int i=0;i<target.length;i++){
            for(int j=i;j<target.length;j++){
                if(flag[i][j]==true&&(j-i)>end-start){
                    start=i;
                    end=j;
                }
            }
        }
        return s.substring(start, end+1);
        }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("ccc"));
    }
}
