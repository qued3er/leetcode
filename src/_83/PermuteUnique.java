package _83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/3  18:18
 */
public class PermuteUnique {
    /*排序+回溯+visited数组
    * 经过排序后相同的数字肯定相邻，我们需要剪枝减去同一层的重复元素
    * 不同层的特征：
    *       */
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //
        Arrays.sort(nums);
        int []visited=new int[nums.length];
        List<Integer> track=new ArrayList<>();
        backPatch(track,visited,nums);
        return res;
    }

    private void backPatch(List<Integer> track, int[] visited,int []nums) {
        if (track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=0;i<nums.length;i++){
            //前边已经用过 表示不再同一层  前面没用过表示在同一层。
            if (i>0&&nums[i]==nums[i-1]&&visited[i-1]==0){
                continue;
            }
            if (visited[i]==0) {
                track.add(nums[i]);
                visited[i] = 1;
                backPatch(track, visited, nums);
                track.remove(track.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique=new PermuteUnique();
        int []nums={1,1,2};
        permuteUnique.permuteUnique(nums);
        System.out.println("res");
    }
}
