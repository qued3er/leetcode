package _728;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/287:47
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        /*
        1.首先拿着hay的第一个元素与needle的第一个元素对比，若相同，则开始匹配。[同步的判断是否相等]
        2.若不同，则仅hay后移。
        结束条件：hay所剩长度<needle的长度。
        特列：如果hay为空串 p非空 返回-1，如果p为空 则返回s的首地址。
        */
        if (needle.equals("")){
            return 0;
        }
        if (haystack.equals("")&&!needle.equals("")){
            return -1;
        }
        char[] hay=haystack.toCharArray();
        char[]need=needle.toCharArray();
        int startIndex=0;
        //i是hay的index j是need的index
        for(int i=0;i<=(hay.length-need.length);){
            //相等开启匹配
            if(hay[i]==need[0]){
                startIndex=i;
                for(int j=0;j<need.length;){
                    if(hay[i]==need[j]){
                        i++;
                        j++;
                        if(j==need.length){
                            return startIndex;
                        }
                    }else{
                        i=i-j+1;
                        break;
                    }
                }
            }else{
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr=new StrStr();
        strStr.strStr("dabef", "abc");
    }
}
