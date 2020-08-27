package _85;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/513:42
 */
public class reverseWords {
    public String reverseWords(String s) {
        s=s.trim();
//        System.out.println(s);
        //连续空格只留一个
        StringBuilder stringBuilder=new StringBuilder();
        char[] target = s.toCharArray();
        stringBuilder.append(target[0]);
        for (int i = 1; i < target.length; i++) {
            if (target[i]==' '&&target[i-1]==' '){
                continue;
            }
            stringBuilder.append(target[i]);
        }
        s=stringBuilder.toString();
//        System.out.println(s);
        target=s.toCharArray();

        reverseWord(target, 0,target.length-1);
        //
        int start=0;
        for (int i=0;i<target.length;i++){
            if (i==target.length-1){
                reverseWord(target, start, i);
            }
            if (target[i]==' '){
                reverseWord(target, start, i-1);
                start=i+1;
            }
        }
        return new String(target);
    }
    public void reverseWord(char[]target,int start,int end){
        int mid=(start+end)/2;
        for (int i=start;i<=mid;i++){
            char temp=target[i];
            target[i]=target[start+end-i];
            target[start+end-i]=temp;
        }
    }

    public static void main(String[] args) {
        reverseWords reverseWords=new reverseWords();
        String s="     the   sky is blue";
        System.out.println(reverseWords.reverseWords(s));
    }
}
