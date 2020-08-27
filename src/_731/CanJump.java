package _731;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/3116:43
 */
public class CanJump {
    public boolean canJump( int[] nums) {
        /*首先找到所有的0
        * 然后需要判断每一个0之前有一个元素的值>它距离0的位置。
        *
        * 从前往后 在它有能力跳过前边的0的基础上判断它是否能跳过后边的0，可以早返回，当前边0不满足后边的0也不满足。
        * */
        List<Integer> zeroIndex=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zeroIndex.add(i);
            }
        }
        boolean zeroFlag=false;
        int distance=0;
        //有一个能跳过该0就可提前break
        //有一个0跳不过就跳不过
        //最后一个元素是0
        for (int i=0;i<zeroIndex.size();i++){
            //两个0之间没有元素
            for (int j=zeroIndex.get(i)-1;j>=0;j--){
                distance++;
                //最后一个元素是0
                if (zeroIndex.get(i)==nums.length-1){
                    if (nums[j] >=distance) {
                        zeroFlag = true;
                    }
                }
                else {
                    if (nums[j] > distance) {
                        zeroFlag = true;
                    }
                }
            }
            if (!zeroFlag){
                return false;
            }
            //开始判断下一个0
            else{
                zeroFlag=false;
                distance=0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump canJump=new CanJump();
        int []nums={2,0,0};
        System.out.println(canJump.canJump(nums));
    }
}
