package _525;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/2514:03
 */
public class Parenthesis {
    //
    List<String> result=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        /**打印出n对括号的所有的组合 括号匹配
         */
        //本次匹配的结果 需要加入list用一个stringbuilder【看了别人的代码使用char更好】
        if(n==0){
            return result;
        }
        if(n==1){
            result.add("()");
            return result;
        }
        findAllSolution(n,n,new char[2*n],0);
        return result;
    }
    //需要知道当前递归还有多少个left括号多少个right括号  使用char数组来记录一个成功的匹配
    //这里使用char就要考虑是使用一个公用的char数组还是每次都开辟一个新的？
    //index之前为已经成功匹配的部分
    public void findAllSolution(int left,int right,char[] oneSample,int index){
        //需要回溯
        if(left>right){
            return;
        }
        if(left==0&&right==0){
            result.add(new String(oneSample));
        }
        //好好考虑为什么这样可以遍历所有的情况？===》

        // 能否改成迭代的代码呢？
        if(left>0){
            oneSample[index]='(';
            findAllSolution(left-1,right,oneSample,index+1);
        }
        if(right>0){
            oneSample[index]=')';
            findAllSolution(left,right-1,oneSample,index+1);
        }
    }
}
