package _88;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/812:54
 */
public class Solutiont {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        /*多个字符串的公共前缀肯定是两个字符串公共前缀的子串*/
        StringBuilder strbuilder=new StringBuilder();
        //初始化StringBuilder
        strbuilder.append(strs[0]);
        //从第二个开始匹配
        int index=1;
        //逐个与之前去公共前缀
        while(index<strs.length) {
            //早退出
            if(strs[index].equals("")||strbuilder.length()==0){
                return "";
            }
            reducePrefix(strbuilder,strs[index]);
            index++;
        }
        return strbuilder.toString();
    }
    //stringBuilder的长度可能大于也可能小于str的长度
    private void reducePrefix(StringBuilder strbuilder, String str) {
        char[] target = str.toCharArray();
        //正向匹配，你想匹配会越界  当stringBuilder的长度>传入的str的长度时。
        //若str.length>strbuilder.length,直接用下边删除    若str.length<strbuilder.length 把他们截成相等
        /*if (target.length<strbuilder.length()){
            strbuilder.delete(target.length, strbuilder.length());
        }
        for (int i=strbuilder.length()-1;i>=0;i--){
            if (target[i]!=strbuilder.charAt(i)){
                strbuilder.deleteCharAt(i);
            }else {
                break;
            }
        }*/


        /* 方法2：
         */
        int startIndex=0;
        //为什么i不会++？
        for (int i=0;i<strbuilder.length()&&i<target.length;){
            if(strbuilder.charAt(i)!=target[i]){
                //这样会删除不完全
//                strbuilder.deleteCharAt(i);

                strbuilder.delete(i, strbuilder.length());
                break;
            }
            else {
                i++;
            }
                startIndex=i;
        }
                strbuilder.delete(startIndex, strbuilder.length());

    }

    public static void main(String[] args) {
        String []strs={"aca","cba"};
        Solutiont solutiont= new Solutiont();
        System.out.println(solutiont.longestCommonPrefix(strs));
    }
}
