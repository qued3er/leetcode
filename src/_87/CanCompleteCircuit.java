package _87;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/713:01
 */
/*
* 给定两个数组一个gas一个cost表示该加油站可提供的油量以及到下一站需要的油量，求从哪点出发可循环一圈？
* */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int []remain=new int[gas.length];
        for (int i = 0; i < remain.length; i++) {
            remain[i]=gas[i]-cost[i];
        }
        //逐个判断每个点是否可以  有一个可以就return
        for (int i=0;i<gas.length;i++){
            //remain+之前的remain
            //记录当前的位置
            int index=i;
            int beforeRemain=0;
            while (remain[index]+beforeRemain>=0){
                beforeRemain=remain[index]+beforeRemain;
                index=(index+1)%gas.length;
                if (index==i){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []gas  = {4,5,2,6,5,3};
        int []cost = {3,2,7,3,2,9};
        CanCompleteCircuit canCompleteCircuit=new CanCompleteCircuit();
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));
    }
}
