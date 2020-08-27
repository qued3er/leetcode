package _818;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/189:36
 */
//给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
    //start子区间起始 end子区间结束
    //start初始为0，判断下一个是否与其相连，相连就end+1，不相邻就添加当前子区间并重置start开始计算下个子区间
    //单个元素与区间的表现形式不一样。
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        int start=0;
        for (int i=1;i<nums.length;i++){
            if ((nums[i]-nums[i-1])!=1){
                if (start!=(i-1)) {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }else {
                    res.add(nums[start]+"");
                }
                start=i;
            }
        }
        //不等才添加导致最后一个没添加
        if (start!=nums.length-1){
            res.add(nums[start]+"->"+nums[nums.length-1]);
        }else {
            res.add(nums[start]+"");
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges=new SummaryRanges();
        int []nums={0};
        System.out.println(summaryRanges.summaryRanges(nums));
    }
}
