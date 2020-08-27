package _812;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/128:35
 */
public class PathSum {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null){
            return res;
        }
        List<Integer>track=new ArrayList<>();
        findAllPathSum(root,sum,track);
        return res;
    }
    //sum是值函数调用自动为我我们回溯  track是引用 需要我们手动回溯
    //要么默认递归过来的可以为空，在函数入口就判空  要么在递归调用前判空 导致传过来不能为空
    private void findAllPathSum(TreeNode root, int sum, List<Integer> track) {
        sum=sum-root.val;
        track.add(root.val);
        if (sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(track));
        }
        if (root.left!=null){
            findAllPathSum(root.left, sum, track);
        }
        if (root.right!=null){
            findAllPathSum(root.right, sum, track);
        }
        track.remove(track.size()-1);
    }
}
