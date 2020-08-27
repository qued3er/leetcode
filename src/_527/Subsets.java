package _527;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/2710:07
 */
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        /**
         * 集合中不包含重复的元素，  总的解集不重复
         * 注意空集
         * 解法：
         * 首先需要对nums去重
         *
         * 1.位图法
         *     注意到若nums数组的长度为x,则x位的二进制可表示所有解。
         *     假设X为3，==》000 001 010 011 100 101 110 111 即可以表示全部解。===》1000瓶酒里有一瓶有毒
         * */
//        编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
//
//        说明：解集不能包含重复的子集。
        //去重,给定一个数组，去除当中所有的重复的元素。===》如果知道范围，可以使用Hash。  不知道范围，可以使用HashMap
        //<Key:value>=<数字:数字出现的次数>


        result=new ArrayList<>();
            int limit=(int) Math.pow(2,nums.length);
            for(int i=0;i<limit;i++){
                List<Integer> subset=new ArrayList<>();
                int temp=i;
                for(int j=0;j<nums.length;j++){
                    //为1表示该位需要加入
                    if(i%2==1){
                        subset.add(nums[j]);
                    }
                    i=i>>1;
//                    i=i/2;
                }
                i=temp;
                result.add(subset);
            }
            return result;
    }

    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        int []nums={1,2,2,3};
        subsets.subsets(nums);
        System.out.println(1);
    }
}
