package _83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/4 10:30
 */
public class CombinationSum {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*通过回溯法  排序 早退出  可重复  每次从上次开始*/
        Arrays.sort(candidates);
        List<Integer> track=new ArrayList<>();
        backPatch(candidates,target,track,0);
        return res;
    }

    private void backPatch(int[] candidates, int target, List<Integer> track, int start) {
        if (target==0){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            if (target > 0) {
                track.add(candidates[i]);
                backPatch(candidates, target - candidates[i], track, i);
                track.remove(track.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int []candidates = {2,3,6,7};
        CombinationSum combinationSum=new CombinationSum();
        combinationSum.combinationSum(candidates, 7);
    }
}
