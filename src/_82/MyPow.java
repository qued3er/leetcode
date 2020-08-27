package _82;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/38:00
 */
public class MyPow {
    public double myPow(double x, int n) {
        /*
        * 使用递归的快速幂乘法。
        * 即在我们求2的8次方时可以将其转化为2的2次方的4次方。
        *
        * 注意:由于n使用的是int32，补码，负值比正值的绝对值>1。
        * 所以 需要先把n转为long，用long来操作，否则会溢出。
        * */
        long pow=n;
        if (pow==0){
            return 1;
        }else if (pow>0){
            return myMul(x,pow);
        }else {
            return 1/myMul(x,-pow);
        }
    }

    private double myMul(double x, long i) {
        if (i==1){
            return x;
        }
        if (i%2==0){
            return myMul(x*x, i/2);
        }else {
            return x*myMul(x*x, i/2);
        }
    }

    public static void main(String[] args) {
        MyPow myPow=new MyPow();
        System.out.println(myPow.myPow(2.00000, 10));
    }
}
