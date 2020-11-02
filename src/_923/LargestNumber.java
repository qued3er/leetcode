package _923;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2215:27
 */
public class LargestNumber {
    //自定义一个比较器
    private class LargeNmberComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            String res1=s1+s2;
            String res2=s2+s1;
            //compareTo是依据Unicode 逐个对char进行比较当不相等就返回其差值。
            return 0-res1.compareTo(res2);
        }
    }
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * [3,30,34,5,9] 9->5->34->3->30
     * 自定义排序  主要是需要证明其传递性
     * 全0返回0
     * 证明：
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        //首先将数字逐个的转换成字符串数组
        String []target=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(target,new LargeNmberComparator());
        StringBuilder res=new StringBuilder(target.length);
        for (String s :
                target) {
            res.append(s);
        }
        //全0的处理
        if (res.toString().split("0").length==0){
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber=new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{0,0}));
    }
}
