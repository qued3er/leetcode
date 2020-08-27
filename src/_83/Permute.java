package _83;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/318:09
 */
public class Permute {
    /*通过回朔法+标记数组来完成*/
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int [] visited=new int[nums.length];
        List<Integer> track=new ArrayList<>();
        backpatch(nums,visited,track);
        return res;
    }

    private void backpatch(int[] nums, int[] visited, List<Integer> track) {
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (visited[i]==0) {
                track.add(nums[i]);
                visited[i]=1;
                backpatch(nums, visited, track);
                track.remove(track.size()-1);
                visited[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        Permute permute=new Permute();
        int []nums={1,2,3};
        permute.permute(nums);
        System.out.println("===");
    }
}
