package _722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2419:22
 */
public class Subsets {
    /*除重方法：当后一位元素与当前元素相同时，index++，跳过元素
    TIPS：这个方法一定要先讨论元素在子集中，再讨论元素不在子集中。*/
    //记录返回结果
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        /*
        通过递归和回溯来完成
        使用回溯的模板代码。
        */
        //先排序 使得相同的元素相邻
        Arrays.sort(nums);
        // 记录走过的路径
        List<Integer> track=new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    void backtrack(int[]nums, int start, List<Integer> track) {
        /*出现了一个之前出现过的错误：List<List<Integer>>外层List放的是内层List的引用 所以我们在修改内层
        * List的时候外层List也会对应的修改。*/
        List<Integer> temp=new ArrayList<>();

        temp.addAll(track);
        res.add(temp);
        for (int i = start; i < nums.length; i++) {
            //跳过同层相同元素
            if (i>start&&nums[i]==nums[i-1]){
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.remove(track.size()-1);
        }
    }
    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        int [] nums={1,2,2,2};
        System.out.println(subsets.subsets(nums));
    }
}
