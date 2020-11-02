package _921;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2113:57
 */
public class IsAdditiveNumber {
    /**
     * 判断一个数是不是累加数，通过回溯法，判断所有的可能 满足就返回
     *
     * "199100199"  解释:1+99=100 99+100=199
     * "112358"
     * @param num 需判断的数字
     * @return  true or false
     */
//    boolean flag=false;
    public boolean isAdditiveNumber(String num) {
        List<String> track=new ArrayList<>();
        return backTrack(track,0,num);
    }

    private boolean backTrack(List<String> track, int startIndex, String num) {
        if (startIndex==num.length()){
            return track.size()>=3;
        }
        //放入满足各个长度的
        for (int i=startIndex;i<num.length();i++){
            String s=num.substring(startIndex, i+1);
            //如果当前不满足前两个元素的和  剪枝
            if (track.size()>=2&&!new BigInteger(track.get(track.size()-2)).add(new BigInteger(track.get(track.size()-1))).equals(new BigInteger(s))){
//                return false;
                //当结果的位数>两个加数的最大长度+1时，可提早返回
                continue;
            }
            //满足||<2个元素可能使之成立  添加进track中。
            if (track.size()<2||new BigInteger(track.get(track.size()-2)).add(new BigInteger(track.get(track.size()-1))).equals(new BigInteger(s))){
                track.add(s);
                //有满足 就返回  否则去试其他情况
                if(backTrack(track, i+1, num)){
                    if (num.charAt(startIndex)=='0'){
                        return false;
                    }
                    return true;
                }
                track.remove(track.size()-1);
            }
            //当前元素 以0起始 需特殊处理
            if (num.charAt(startIndex)=='0'){
                return false;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber=new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("101"));
    }
}
