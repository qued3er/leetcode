package _817;

import java.util.Arrays;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/179:13
 */
/*最大值最小问题：
给定一个数组，将其划分成 MM 份，使得每份元素之和最大值最小，每份可以任意减去其中一个元素。


* 暴力解法：找所有的可能时间逐个判断  并记录 求最大值
* 优化 用二分去查找[需要有序 排序]
* 首先需要确定时间的上下界：[暴力二分都需要]
* 其次 需要找出一个时间 作为最多的时间的一天  去判断它是否能成立
* [采用二分/逐个判断]===》二分更好
* 小杨？ ==》下届最小值为0   上界：最多的最少[不用小杨 ]
*
* [每天都要用小杨 让小杨去做每天中时间最长的那道题]
* 必须按顺序的去刷题  所以小杨能帮的是当前天的最大值。
*
* */
public class MinTime {
    public int minTime(int[] time, int m) {
        //天>=题直接返回0
        if (m>=time.length){
            return 0;
        }
        //找到初始边界
        int min=0;
        int max=0;
        for (int i=0;i<time.length;i++){
            max=max+time[i];
        }
        //二分的查找符合要求的最小值
        while (min<=max){
            //拿mid当天数中的最大时间的最小值
            int mid=(min+max)/2;
            //最大时间的最小值 [尽可能小]
            // 如果当前满足那么表示可以继续缩小 max=mid-1;
            //如果当前的不满足  表示当前的最大时间  应该扩大
            //不应该满足啊？？？
            if (checkSAT(mid,m,time)){
                max=mid-1;
            }else {
                min=mid+1;
            }
        }
        return min;
    }
    //daytime 最大时间  要用小杨去最大  对数组进行划分 把daytime当做每天的最长时间[减去小杨做最大的]
    //所以还需要维护当前子数组中的最大值是多少
    //check的解决办法 维护当前除去最大值的sum  当遇到一个新值的时候 根据其与之前的max的谁大谁小分情况处理
    //在每种情况里看 当前的数组是否超过最大值
    private boolean checkSAT(int maxDayTime, int days, int[] time) {
        //最后判断day是否满足要求 ===》因为我们对第0个初始  所以天数应该初始化为1
        int availableDay=1;
        int max=time[0];
        //time[0]-max
        int sumTime=time[0]-max;
        //划分过程出现了问题  没小杨直接划分  有了小杨 还要找最大且满足减了最大之后不能再加再加就要超过max
        //所以sum应该维护的是当前子数组的和减去当前子数组的最大值。  sum不能再加
        for (int i = 1; i < time.length; i++) {
            if (time[i]>max){
                //不能加入  重置找下一个数组[要不要找下一个数组]
                if ((sumTime+max)>maxDayTime){
                    sumTime=0;
//                    max=time[i];
                    availableDay++;
                }
                //可加入 更新max
                else {
                    //sumtime为sumtime加上之前的
                    sumTime=sumTime+max;
                }
                max=time[i];
//                time[i]=max;
            }else {
                if ((sumTime+time[i])>maxDayTime){
                    sumTime=0;
                    max=time[i];
                    availableDay++;
                }else {
                    sumTime=sumTime+time[i];
                }
            }
        }
        if (availableDay<=days){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MinTime minTime=new MinTime();
        int []time={1,2,3,3};
        System.out.println(minTime.minTime(time, 2));
    }
}
