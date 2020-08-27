package _526;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/2610:21
 */
public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        /**
         分而治之的思想
         整体的思想就是先把 n-1个盘子从A移动到B，把最下边的盘子移动到C然后再把B上的移动到C。
         */
        move(A.size(),A,B,C);
    }
    //size为需要从A移动到C上的盘子的个数
    //为什么这个可以达到从小到大的顺序呢？
    private void move(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        //出口
        if(size==1){
            c.add(a.remove(a.size()-1));
            return;
        }
        //size-1个从a移动到b
        //注意c，b一直在交换
        move(size-1, a, c, b);
        //把a最后一个移动到c
        c.add(a.remove(a.size()-1));
        //再把b的移动到c
        move(size-1, b, a, c);
    }

    public static void main(String[] args) {
        Hanota hanota=new Hanota();
        List<Integer> A=new ArrayList<>();
        List<Integer> B=new ArrayList<>();
        List<Integer> C=new ArrayList<>();
        for(int i=3;i>=0;i--){
            A.add(i);
        }
        hanota.hanota(A, B, C);
    }
}
