package _818;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1810:10
 */
//找所有超过n/3向下取整的元素
    //要求时间：O(n) 空间O(1)
    //要求一次遍历 不使用额外的空间
    //摩尔投票法的扩展
    //对于两个元素的摩尔投票法，我们相当于每次删除两个不一样的元素，删除至无相同的元素为止。
    //基于定理：我们每次删除2个不一样的元素，原来>n/2的元素经过删除之后仍大于n/2;
    //我们可证明至k，即每次删除k个不一样的元素，原来>n/k的元素经过每一轮删除之后仍然大于n/k.
    //其次 证明：一个数组中  超过1/k的元素最多有 k-1个。
    // k-1个元素的比例超过1/k，那么我们用1减去他们的比例相加 剩下的小于 1/k 证毕
   /* 实现:
   维持k-1个major当做 候选人[常数空间]，每来一个元素就逐个与major对比，看投不投他们，如果投，对应major的投票数+1,
   如果不投，则所有major的数量都要-1，遇到==0的就把当前数字放上去作为新的候选人[相当于投自己]。 时间复杂度O(n) 循环
   内的遍历次数是常量级别的。
   需要注意的是 最后的major是可能的候选人，还需要看其对应的majornumber
    */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        //初始化major1,2
        int major1=nums[0];
        int majorNumber1=1;
        int major2=0;
        int majorNumber2=0;
        //初始化第二个
        int startIndex=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==major1){
                majorNumber1++;
            }else {
                major2=nums[i];
                majorNumber2++;
                startIndex=i+1;
                break;
            }
        }
        //遍历删除
        for (int i=startIndex;i<nums.length;i++){
            if (nums[i]==major1){
                majorNumber1++;
                continue;
            }
            if (nums[i]==major2){
                majorNumber2++;
                continue;
            }
            //如何达到1次替换一个的效果？
            if (majorNumber1==0){
                major1=nums[i];
                majorNumber1=1;
                continue;
            }
            if (majorNumber2==0){
                major2=nums[i];
                majorNumber2=1;
                continue;
            }
            majorNumber1--;
            majorNumber2--;
        }
        int num1=0,num2=0;
        //确定备选人是否真的具备资格
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==major1){
                num1++;
            }else if (nums[i]==major2){
                num2++;
            }
        }
        if (num1>(nums.length/3)){
            res.add(major1);
        }
        if (num2>(nums.length/3)){
            res.add(major2);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElement2 majorityElement2=new MajorityElement2();
        int []nums={2,3,2};
        majorityElement2.majorityElement(nums);
    }
}
