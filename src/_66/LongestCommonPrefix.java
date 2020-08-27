package _66;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/619:46
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        /*拿第一个字符串与第二个字符串进行求最长公共前缀，然后将拿到的结果再与第三个...最后一个进行最长公共前缀。所得的结果即为最长公共前缀。*/
        int end=strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(end==0){
                return "";
            }
            end=findCommonPrefix(strs[0],end,strs[i]);
        }
        if(end==0){
            return "";
        }
        return strs[0].substring(0, end);
    }
    //end第一个不公共的点。
    private int findCommonPrefix(String s1, int end, String s2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int i=0;
        for(;i<end&&i<s2.length();i++){
            if(c1[i]!=c2[i]){
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        String [] s={"aa","a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(s));
    }
}
