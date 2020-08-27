package _818;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/189:59
 */
//多数元素的特点  拿一个多数元素去抵消一个非多数 最后还剩下>=1个
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major=nums[0];
        int majorNumber=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==major){
                majorNumber++;
            }else {
                majorNumber--;
                //当为0的时候肯定不是最后一个元素
                if (majorNumber==0){
                    i++;
                    major=nums[i];
                    majorNumber=1;
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement=new MajorityElement();
        int []nums={3,2,3};
        System.out.println(majorityElement.majorityElement(nums));
    }
}
