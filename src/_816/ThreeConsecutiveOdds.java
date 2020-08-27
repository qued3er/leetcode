package _816;

import _66.ThreeSum;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1610:38
 */
public class ThreeConsecutiveOdds {
    //滑动窗口
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddNumber=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]%2==1){
                oddNumber++;
                if(oddNumber==3){
                    return true;
                }
            }else{
                oddNumber=0;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeConsecutiveOdds threeConsecutiveOdds=new ThreeConsecutiveOdds();
        int []arr={1,2,34,3,4,5,7,12};
        System.out.println(threeConsecutiveOdds.threeConsecutiveOdds(arr));
    }
}
