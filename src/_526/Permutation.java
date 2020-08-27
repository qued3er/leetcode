package _526;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/268:24
 */
public class Permutation {
    //使用hashSet是不是会更好
    List<String> container;
    String []result;
    public String[] permutation(String S) {
        /**
         给定一个字符串，输出其字符所有的排列组合。
         注意：剪枝[字符相同]
         基于交换生成，每次交换，如果不相同就生成新的字符串。
         */
        container=new ArrayList<>();
        char [] target=S.toCharArray();
        findAllOrder(target,0);
        result=new String[container.size()];
        return container.toArray(result);
    }

    private void findAllOrder(char[] target, int changeIndex) {
        String element=new String(target);
        if(!container.contains(element)) {
            container.add(element);
        }
        //出口
        if(changeIndex==target.length-1){
            return;
        }
        //这样第一个没递归处理。
        for(int i=changeIndex;i<target.length;i++){
                //changeIndex与i交换
            exchange(target, changeIndex, i);
            findAllOrder(target, changeIndex + 1);
//            container.add(new String(target));


            //关键步骤   回溯
            exchange(target, changeIndex, i);

        }
    }

    private void exchange(char[] target, int changeIndex, int i) {
        char temp=target[changeIndex];
        target[changeIndex]=target[i];
        target[i]=temp;
    }

    public static void main(String[] args) {
        Permutation permutation=new Permutation();
        permutation.permutation("abc");
    }
}
