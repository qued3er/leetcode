package _816;

import _814.MinSubArrayLen;

import javax.management.openmbean.OpenMBeanAttributeInfo;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1611:01
 */
public class MinOperations {
    public int minOperations(int n) {
        //看n是偶数还是奇数,如果n为奇数，那么则是以2位底，前 n/2项的等差数列的和，其中差为2  如果n是偶数，那么则是以1为底，前n/2项的等差数列的和。
        //等差数列的求和公式为(a1+an)*n/2;
        int res=0;
        if(n%2==0){
            res=((1+(2*(n/2)-1))*(n/2))/2;
        }else{
            res=((2+2*(n/2))*(n/2))/2;
        }
        return res;
    }

    public static void main(String[] args) {
        MinOperations minOperations=new MinOperations();
        System.out.println(minOperations.minOperations(6));
    }
}
