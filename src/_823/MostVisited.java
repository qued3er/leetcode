package _823;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2313:53
 */
public class MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res=new ArrayList<>();
        int start=rounds[0];
        int end=rounds[rounds.length-1];
        //把从start->end的所有都加入res
        if (start>end){
            end=end+n;
        }
        if (end<=n){
            //直接添加
            for (int i=start;i<=end;i++){
                res.add(i);
            }
        }else {
            for (int i=1;i<=end-n;i++){
                res.add(i);
            }
            for (int i=start;i<=n;i++){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MostVisited mostVisited=new MostVisited();
        int []nums={3,1,2};
        System.out.println(mostVisited.mostVisited(4, nums));
    }
}
