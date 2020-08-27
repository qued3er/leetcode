package _731;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/319:27
 */
public class Merge {
    /**
     * 首先对整个二维数组按照left进行排序
     * 然后逐个判断是否需要与前一个区间进行合并：
     * 1.frontRight<backLeft 不需要合并 cur++
     * 2.frontRight>=backLeft 需要合并
     *      合并就需要删除
     *      如何实现删除？==》1.通过覆盖  2.
     *      2.1left为frontLeft，right为max(frontRight,backRight)
     *      不cur++,继续与下一个判断*/
    public int[][] merge(int[][] intervals) {
        //关键点是如何确定merge后数组的大小==》通过ArrayList的toArray的泛型
        ArrayList<int[]>res=new ArrayList<>();
        //需要自定义一个comparator
        Arrays.sort(intervals,new TwoDimensionalArrayComparator());

        for (int i=1;i<intervals.length;i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {
                res.add(intervals[i - 1]);
            } else {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                intervals[i][0]=intervals[i-1][0];
            }
        }
        //最后一个没法添加
        res.add(intervals[intervals.length-1]);
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        Merge merge=new Merge();
        int [][]interv={
                {15,18},{8,10},{2,6},{1,3}
        };
        merge.merge(interv);
    }
}
