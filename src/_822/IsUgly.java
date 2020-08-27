package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2217:07
 */
public class IsUgly {
    public boolean isUgly(int num) {
        //如何判断一个数能够被2/3整除看他对该数取余是否为0
        while((num&0x00000001)==0){
            //为什么除不行
//            num=num/2;
            num=num>>1;
        }
        while(num%3==0){
//            num=num>>2;
            num=num/3;
        }
        while (num%5==0){
            num=num/5;
        }
        if (num==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsUgly isUgly=new IsUgly();
        System.out.println(isUgly.isUgly(6));
    }
}
