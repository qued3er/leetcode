package _66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/620:51
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
            求三数之和。
         1.首先对nums进行排序
         2.然后固定一个k，再维持两个指针，一个指向k+1的位置，一个指向数组的最后一个元素，因为k之前的能与k+1到最终2个数
         组合为0的都已经添加了。
         3.
                当k位置的元素>0，直接返回，因为之后不可能再有和为0的了
                当nums[k]=nums[k-1]...，跳过所有相同的仅仅保留一个
                当 三个元素的和s<0,则i++，[注意当nums[i+1],i+2....与nums[i]相同的都要跳过]。
                当三个元素的和s>0的时候，则j--,[注意要跳过所有与nums[j]]相同的。
                当s==0的时候 添加  并且跳过左右的相等
         */
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            if(nums[k]>0){
                break;
            }
            for(int i=k+1,j=nums.length-1;i<j;){
                int s=nums[k]+nums[i]+nums[j];
                if(s==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(temp);
                    //也要去重
                    int temp1=nums[i];
                    i++;
                    while(j>=i&&nums[i]==temp1){
                        i++;
                    }
                    int temp2=nums[j];
                    j--;
                    while(j>=i&&nums[j]==temp2){
                        j--;
                    }
                }else if(s>0){
                    int temp=nums[j];
                    j--;
                    while(j>=i&&nums[j]==temp){
                        j--;
                    }
                }else {
                    int temp=nums[i];
                    i++;
                    while(j>=i&&nums[i]==temp){
                        i++;
                    }
                }
            }
            while (k<nums.length-1&&nums[k]==nums[k+1]){
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums={-2,0,0,2,2};
        ThreeSum threeSum=new ThreeSum();
        threeSum.threeSum(nums);
    }
}
