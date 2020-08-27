package _68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/814:34
 */
public class FourSum {
    List<List<Integer>> result;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 找出所有不重复的和为target的四元组。
         * 首先对nums进行排序，然后定两个数的位置k,m
         *          if(nums[k]>target) 则之后没必要再遍历了。
         *          如果nums[k]==nums[k+1]并且nums[m]==nums[m+1]则同步后跳。
         *        然后通过两个指针指向m+1,nums.length。
         *          s==0，添加进结果集中,左右指针移动至于前一个不相等的位置。
         *          s<0，左指针右移到第一个与之前一个元素不相等的位置。
         *          s>0，右指针左移到第一个与之前一个元素不想等的位置。
         */
        result=new ArrayList<>();
        Arrays.sort(nums);
        for (int k=0;k<nums.length;k++){
            if(target>=0&&nums[k]>target){
                return result;
            }
            for(int m=k+1;m<nums.length;m++){
                for(int i=m+1,j=nums.length-1;i<j;){
                    int s=nums[k]+nums[m]+nums[i]+nums[j];
                    if(s==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[k]);
                        temp.add(nums[m]);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        result.add(temp);
                        //移动到第一个不相等的位置
                        int temp1=nums[i];
                        i++;
                        while(i<j&&nums[i]==temp1){
                            i++;
                        }
                        int temp2=nums[j];
                        j--;
                        while(i<j&&nums[j]==temp2){
                            j--;
                        }
                    }else if (s<target){
                        int temp1=nums[i];
                        i++;
                        while(i<j&&nums[i]==temp1){
                            i++;
                        }
                    }else {
                        int temp2=nums[j];
                        j--;
                        while(i<j&&nums[j]==temp2){
                            j--;
                        }
                    }
                }
                int tempm=nums[m];
                while(m<nums.length-1&&nums[m+1]==tempm){
                    m++;
                }
            }
            int tempk=nums[k];
            while(k<nums.length-1&&nums[k+1]==tempk){
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum=new FourSum();
        int [] nums={1,-2,-5,-4,-3,3,3,5};
        fourSum.fourSum(nums,-11);
    }
}
