package _816;

import java.util.Arrays;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1611:32
 */
/*最大值最小，最小值最大问题===》二分查找+贪心
* 二分查找 [是为了优化查找 我们不逐个的对间距的可能进行判断   而是二分]：
* 所以我们首先要确定二分的初始范围：最小值就是找最小间距的两个值的差值。
* 最大值是：(最大的间距)/(m-1)        m-1表示间隔，不是除以m是因为最大间距算出来的也是间隔。
* 证明最大值:反证  假设最小间距为y  且大于上述  那么其他的间距>y，y*(m-1)>x*(m-1)[x为上述判定的最小最大]则有比最大间距还大的
* 与假设矛盾
*
* [拿mid当最小磁力]使用二分逐步的缩小范围：如果当前的最小磁力[mid]能满足m个球放到这个position数组中，则
* 表示最小磁力还能更大，如果不能则表示需要减小当前最小磁力。
* */
public class MaxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        //找初始化的最大最小
        int min=position[1]-position[0];
        for (int i = 2; i < position.length; i++) {
            if ((position[i]-position[i-1])<min){
                min=position[i]-position[i-1];
            }
        }
        int max=(position[position.length-1]-position[0])/(m-1);
        while (min<=max){
            int mid=(min+max)/2;
            //判断间隔为m-1 间距为mid 能不能塞到position数组中。
            if(checkValue(mid,position,m)){
                //当前磁力可以胜任 就尝试扩大它【等于mid会死循环】
                min=mid+1;
            }else {
                max=mid-1;
            }
        }
        return max;
    }

    private boolean checkValue(int distance, int[] position, int m) {
        //贪心放  number表示当前已经放了的球个数[第一个已经放入]
        int number=1;
        //
        int i=1;
        //上次球的位置
        int index=position[0];
        while (i<position.length){
            if ((position[i]-index)>=distance){
                index=position[i];
                number++;
            }
            i++;
        }
        if (number<m){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        MaxDistance maxDistance=new MaxDistance();
        int []position={1,2,3,4,7};
        System.out.println(maxDistance.maxDistance(position, 3));
    }
}
