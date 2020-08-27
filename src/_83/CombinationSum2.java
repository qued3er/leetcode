package _83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/410:57
 */
/*数组会有重复元素*/
public class CombinationSum2 {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //加上当前点超过tar之后的都不用加了
        Arrays.sort(candidates);
        List<Integer>track=new ArrayList<>();
        backPatch(track,candidates,target,0);
        return res;
    }
    private void backPatch(List<Integer> track, int[] candidates, int target, int start) {
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i>0&&i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            track.add(candidates[i]);
            backPatch(track, candidates, target-candidates[i],i+1);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2=new CombinationSum2();
        int []can={2,5,2,1,2};
        combinationSum2.combinationSum2(can, 5);
    }
}
