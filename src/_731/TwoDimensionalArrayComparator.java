package _731;

import java.util.Comparator;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3111:43
 */
public class TwoDimensionalArrayComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int [] a1=(int[])o1;
        int [] a2=(int[])o2;
        if (a1[0]<a2[0]){
            return -1;
        }else if (a1[0]==a2[0]){
            return 0;
        }else{
            return 1;
        }
    }

}
