package _728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2811:07
 */
public class Combine {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // 记录走过的路径
        List<Integer> track=new ArrayList<>();
        int []nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        //应该再加上一个深度
        backtrack(nums, 0, track,k);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> track,int depth) {
        //剪枝
        if (depth==0) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(track);
            res.add(temp);
            return;
        }
        //start=0时；i=0 i=1 i=2 i=3 各是一棵子树。 i=0子树的构建通过[1,2,3] i=1的通过[2,3]
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track,depth-1);
            // 撤销选择
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        Combine combine =new Combine();
        combine.combine(4, 2);
    }
}
