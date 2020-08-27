package _818;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/187:44
 */
//1-9的数字k个  和为n 不能重复使用  对1-9的的所有k个数字的组合遍历找   1.不能有重复解 2.解内不能有重复的数字
    //使用回溯
    //对数字可以重复使用[start=i]  1,1,2前边遍历过了    1,2,1的判断结果与1,1,2相同。 所以下次 1,2,下一个数从2开始
    //对数字不能重复使用[start=i+1]
    //顺序有关[1,2,3与1,3,2不同]：不使用start，每次从头开始，使用used数组。
    //顺序无关[1,2,3与1,3,2相同]：使用start  之前用过的不用了

    //1.多余k个数字就截断 2.taget<0就截断 [全正整数 一个小于0子树再减也是小于0]
public class CombinationSum3 {
    List<List<Integer>>res;
    CombinationSum3(){
        res=new ArrayList<>();
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>track=new ArrayList<>();
//        boolean []used=new boolean[10];
        backtrack(1,track,k,n);
        return res;
    }

    private void backtrack(int start,List<Integer> track, int k, int n) {
        if (n<0){
            return;
        }
        if (k<0){
            return;
        }
        if (k==0&&n==0){
            res.add(new ArrayList<>(track));
        }
        for (int i = start; i <=9 ; i++) {
//            if (!used[i]){
            //有序数组可使用早退出
            if ((n-i)<0){
                break;
            }
                track.add(i);
//                used[i]=true;
                backtrack(i+1,track,k-1,n-i);
                track.remove(track.size()-1);
//                used[i]=false;
//            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3=new CombinationSum3();
        combinationSum3.combinationSum3(3, 9);
    }

}
