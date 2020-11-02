package _1029;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * @date 2020/10/29 8:15
 */
public class LexicalOrder {
    //把整个数的集合当做一棵树，该树的先序遍历集合即为该集合的字典顺序。
    public List<Integer> lexicalOrder(int n) {
        //即首先是以1开头的，当前缀相同根据当前为的大小来排，无最前。
        List<Integer> result=new ArrayList<>();
        //相当于track
        int tmp=0;
        dfs(tmp,result,n);
        return result;
    }

    private void dfs(int tmp, List<Integer> result,int max) {
        if (tmp>max){
            return;
        }
        for (int i = 0; i <=9; i++) {
            tmp=tmp*10+i;
            //跳过0
            if (tmp==0){
                continue;
            }
            //大于max时就需要返回。  以这个开头的最大值已经到达。
            if (tmp>max){
                return;
            }
            result.add(tmp);
            dfs(tmp, result, max);
            tmp=(tmp-i)/10;
        }
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder=new LexicalOrder();
        System.out.println(lexicalOrder.lexicalOrder(13));
    }
}
