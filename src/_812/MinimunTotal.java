package _812;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/128:57
 */
public class MinimunTotal {
    //要给他初始化一个很大的数
    //优化：有重复计算，首先要明确的是重复计算在哪儿？
    //exp：
    //   1
    //  2 3
    // 4 5 6
    //7 8 9 10
    //我们在求到8，到9的最小值的时候我们重复使用了到5的最小值去比较



    //记录法
    int minimun=Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        findAllPath(triangle,0,0,0);
        return minimun;
    }

    private void findAllPath(List<List<Integer>> triangle, int column, int row, int sum) {
        sum=sum+triangle.get(column).get(row);
        if (column==triangle.size()-1){
            if (sum<minimun){
                minimun=sum;
            }
        }
        if (column<triangle.size()-1){
            findAllPath(triangle, column+1, row, sum);
            if (row<triangle.get(column+1).size()-1){
                findAllPath(triangle, column+1, row+1, sum);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>l1=new ArrayList<Integer>(){{
            add(-1);
        }};
        List<Integer>l2=new ArrayList<Integer>(){{
            add(-2);
            add(-3);
        }};
//        List<Integer>l3=new ArrayList<Integer>(){{
//            add(6);
//            add(5);
//            add(7);
//        }};
//        List<Integer>l4=new ArrayList<Integer>(){{
//            add(4);
//            add(1);
//            add(8);
//            add(3);
//        }};
        List<List<Integer>>tri=new ArrayList<List<Integer>>(){{
            add(l1);
            add(l2);
//            add(l3);
//            add(l4);
        }};
        MinimunTotal minimunTotal=new MinimunTotal();
        System.out.println(minimunTotal.minimumTotal(tri));
    }
}
