package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2215:55
 */
//寻找重复元素 重复元素只有一个[重复的次数>=2]
    //二分法：基于如果重复的元素>i， 那么ct[i]<=i  ct[i]表示小于等于i的元素的个数。
    //所以 我们对一个元素  如果他的ct[i]>i,那么我们可以确定我们要找的一定在我们左边。
    //否在重复元素一定在我们右边
    //对于>的时候 好理解
    //对于<=的时候我们要证明一下
    //反证法：假设在我们左边
    //由于元素的个数  比坑的个数>1所以在拿重复数组填完坑之后肯定会多余1个元素。
    //重复元素填坑的位置是大于重复元素: 那么cn[target=>重复元素]=target+1
    //....小于重复元素，cn[target]>target+1； 与cn[i]<=i违背。
    //界限  数组的长度为n  那么数字的范围为：1->n-1
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        int min=1;
        int max=nums.length-1;
        while (min<max){
            int mid=min+(max-min)/2;
            //大于返回true
            if (check(mid,nums)){
                max=mid;
            }else {
                min=mid+1;
            }
        }
        return min;
    }

    private boolean check(int mid, int[] nums) {
        int number=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=mid){
                number++;
            }
        }
        if (number>mid){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        findDuplicate findDuplicate=new findDuplicate();
        int []nums={1,3,4,2,2,};
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}
