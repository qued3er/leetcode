package _813;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/138:46
 */
//动态规划：假设f(i)表示以i结束的不重复子串的最大长度
// 状态转移方程：如果target[i+1]与之前的元素不重复： f(i+1)=f(i)+1  否则就是有重复元素：f(i+1)=i+1  - 重复元素的index。
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s){
        char[] target = s.toCharArray();
        int []subLength=new int[target.length];
        //底
        subLength[0]=1;
        for (int i=1;i<subLength.length;i++){
            //false 无重复
            int dupIndex=-1;
            //判断是否已之前的元素重复  ===》可以用hash优化
            for (int j=i-1;j>=0;j--){
                if (target[i]==target[j]){
                    dupIndex=j;
                }
            }
            if (dupIndex==-1){
                subLength[i]=subLength[i-1]+1;
            }else {
                subLength[i]=i-dupIndex;
            }
        }
        int longest=subLength[0];
        //遍历sub找最大
        for (int i=1;i<subLength.length;i++){
            if (subLength[i]>longest){
                longest=subLength[i];
            }
        }
        return longest;
    }
}
