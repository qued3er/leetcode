package _527;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/279:12
 */
public class Multiply {
    int result;
    public int multiply(int A, int B) {
        /**
         首先把B简化为以1开头其余全0的x二进制的数相加。
         15=8+4+2+1=1000+100+10+1
         然后对A分别左移所含0的个数位，然后将所有的结果相加。

         递归乘法的话，先将B转换成二进制，然后从右向左，如果当前位为1，则将A左移右部0的个数位，然后加至结果中。
         直至到第一个。
         */
        //迭代的方式 改为递归
//        int [] binB=new int [32];
//        //将B转化为2进制的数组。
//        for(int i=0;i<32;i++){
//            if(B%2==0){
//                binB[i]=0;
//            }else{
//                binB[i]=1;
//            }
//            B=B/2;
//        }
//        //现在binB中为B的二进制，从左到右从低位到高位
//        for(int i=0;i<32;i++){
//            if(binB[i]==1){
//                result+=A<<i;
//            }
//        }
//        return  result;
        /**
         * 采用递归的方式每次乘以当前位的最低位的二进制的数字
         * */
        multiplyRecursion(A,B,0);
        return result;
    }
    //x为当前为1需要移的位数
    private void multiplyRecursion(int A,int B,int x) {
        //出口
        if(B==0){
            return;
        }
        if(B%2==1){
            result+=A<<x;
        }
        B=B>>1;
        multiplyRecursion(A, B, x+1);
    }

    public static void main(String[] args) {
        Multiply multiply=new Multiply();
        System.out.println(multiply.multiply(4, 5));
    }
}
