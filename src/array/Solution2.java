package array;

public class Solution2 {
    public String replaceSpace(String s) {
        /**思路1：把空格替换成括号。
         */
        // return s.replaceAll(" ","%20");

    /*思路2：先把String转化为字符数组，然后将字符数组中的空格逐个替换为%20。
      但是考虑，对于思路2，如果按照常规的思路，从前到后寻找空格并替换，由于空格占一个字符，而%20占3个字符，所以会导致每个空格之后的所有字符都后移，所以对于O(n)个字符的字符串，其时间复杂度为O(n²)

      所以考虑从后往前
      1.先遍历一遍字符数组，记录其中的空格数，然后设置2个指针P1和P2，其中p1指向原字符数组末尾，p2=p1+2x空格个数
      2.然后从后向前遍历，如果当前字符为非空格，就把P1的字符复制到P2的位置，如果为空格，则P1向前移动一格，而p2向前走三下，并逐个写入0 2 %，直至p1=p2,全部替换完毕。*/
       char [] myChar=s.toCharArray();
        int spaceNumber=0;
        for (char a:
                myChar) {
            if(a==' '){
                spaceNumber++;
            }
        }
        int resultLength=myChar.length+2*spaceNumber;
        char [] result=new char [resultLength];
        for(int p1=myChar.length-1,p2=resultLength-1;p1!=p2;){
            if(myChar[p1]!=' '){
                result[p2]=myChar[p1];
                p1--;
                p2--;
            }else {
                p1--;
                result[p2]='0';
                p2--;
                result[p2]='2';
                p2--;
                result[p2]='%';
                p2--;
            }
        }
        return new String(result);
    }
}
