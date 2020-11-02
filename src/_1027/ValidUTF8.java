package _1027;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/10/279:17
 */
/*UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：

对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
这是 UTF-8 编码的工作方式：

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。

注意:
输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。

示例 1:

data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.

返回 true 。
这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
示例 2:

data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.

返回 false 。
前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
下一个字节是开头为 10 的延续字节，这是正确的。
但第二个延续字节不以 10 开头，所以是不符合规则的
 */
//消化后的，
// 如果1字节的UTF8编码，首位为0 其余为unicode码点，所以可表示的范围为0-7F
// 如果为2字节的UTF8编码，第一个字节首位为110，第二个字节首位也为10,范围为80-7FF[11位]
// 如果是3个字节的UTF8编码，1110,10,10,其余均为unicode码点，800-FFFF [16位]
// 如果是4个字节的UTF8编码，11110,10,10,10，其余均为unicode码点，10000-1FFFFF[21位]
// 对给定的int数组判断其是否为有效的UTF-8编码
/*
需要确定一个数的二进制是否符合某规则的时候，我们应该怎样选择什么样的位运算？
    如果我们仅需测试1位是否符合规则，可使用一个掩码做与即可完成判断。[与1相与 为0则0 为1则1]
    如果需要的位数较小，我们可使用多个进行与多次校验。
    能不能构造出来一个数，进行与/或/异或直接完成多次校验的判断？[ex:我要校验是否n个1开始接1个0？如何一次完成？]
    当需要校验的位数比较多时，就不方便了。 我们此时可以用异或，构造出需要校验的所有的位，


    DFA做法：
    先确定一共有几种状态：
 */
public class ValidUTF8 {
    public boolean validUtf8(int[] data) {
        int bytesToBeProceed=0;
        int mask1=0b10000000;
        int mask2=0b01000000;
        for (int i=0;i<data.length;i++){
            //当前等待进入字符判断
            if (bytesToBeProceed==0){
                int mask=0b10000000;
                if ((mask&data[i])==0){
                    continue;
                }
                while ((mask&data[i])!=0){
                    bytesToBeProceed++;
                    mask>>=1;
                }
                if (bytesToBeProceed > 4 || bytesToBeProceed == 1) {
                    return false;
                }
                bytesToBeProceed--;
            }
            //当前已经在字符判断中 每次消耗一个bytesToBeProceed.
            else {
                if ((data[i]&mask1)==mask1&&(data[i]&mask2)==0){
                    bytesToBeProceed--;
                }else {
                    return false;
                }
            }
            if (i==data.length-1&&bytesToBeProceed!=0){
                return false;
            }
        }
        //之后的字符的个数不足以支撑当前字节的起始1的个数仍需要返回false；
        return true;
    }

    public static void main(String[] args) {
        ValidUTF8 validUTF8=new ValidUTF8();
        System.out.println(validUTF8.validUtf8(new int[]{237}));
    }
}
