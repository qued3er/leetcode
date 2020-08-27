package _530;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/3010:47
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        /**
         * 1.两个字符串的长度必须满足一下两种情况的一种：
         *      长度相同====》替换操作，即仅有一个字符不同
         *      长度差一个字符====》短的字符按序出现在长字符里
         *      */
        char []shortString;
        char []longString;
        if(first.length()>second.length()){
            shortString=second.toCharArray();
            longString=first.toCharArray();
        }else {
            shortString=first.toCharArray();
            longString=second.toCharArray();
        }
        //替换操作只能有一个不一样，增加操作只能有一个字符是没有的
        int flag=1;
        //替换操作,需要判断的是逐位判断字符是否相等
        if(shortString.length-longString.length==0){
            for(int i=0;i<shortString.length;i++){
                if(flag>=0){
                    if(shortString[i]!=longString[i]){
                        flag--;
                    }
                }
            }
        }
        //增加操作,逐位判断 只能跳过一个字符
        if(longString.length-shortString.length==1){
            for(int _short=0,_long=0;_long<longString.length;){
//                if(shortString[_short]=longString[_long])
            }
        }
        return true;
    }
}
