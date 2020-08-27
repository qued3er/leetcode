package _825;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/257:45
 */
/**使用递归来解决
 *  根据某个符号 可以把该表达式划分成两个部分   对两个部分分别计算[求所有可能] 最后再进行最后一个计算
 *  2*(3-(4*5))
 *  */
public class DiffWaysToCompute {
        Set<Character> dict=new HashSet<Character>(){{
            add('+');
            add('-');
            add('*');
        }};
        List<Integer> res=new ArrayList<>();
    public List<Integer> diffWaysToCompute(String input) {
        char[] target = input.toCharArray();
        for (int i=0;i<target.length;i++){
            if (dict.contains(target[i])){
                int value1=parseRecruision(0,i-1,target);
                //value2可以产生多值  而这儿只产生了1个值  导致解少了
                int value2=parseRecruision(i+1,target.length-1,target);
                res.add(calucate(value1,value2,target[i]));
            }
        }
//        parseRecruision(0,target.length-1, target);
        return res;
    }

    private Integer calucate(int value1, int value2, char op) {
        switch (op){
            case '+': return value1+value2;
            case '-': return value1-value2;
            default : return value1*value2;
        }
    }
    //如何让value1固定的时候  value2产生多值？    value2固定的时候 value1产生多值。
    private int parseRecruision(int start, int end, char[] target) {
        if (start==end){
            return target[start]-48;
        }
        int res=0;
        for (int i=start;i<=end;i++){
            if (dict.contains(target[i])){
                int value1=parseRecruision(start,i-1,target);
                int value2=parseRecruision(i+1,end,target);
                res=calucate(value1,value2,target[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiffWaysToCompute diffWaysToCompute=new DiffWaysToCompute();
        diffWaysToCompute.diffWaysToCompute("2*3-4*5");
    }
}
