package _61;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/110:14
 */
public class MaximumProduct {
    /*public int maximumProduct(int[] nums) {
        /**
         全正
         最大的三个数
         全负
         最小的三个数
         上述两种可总结为排序后最大的三位数

         有正有负：结果为正的情况：一正两负   三正  =》一正就是最大的哪个正
         比较两个最小的负数与两个次大的整数的大小，谁大就是谁

         所以可总结为：
         max(最大的三位数，最小的两位数*最大的一位数)

         排序与不排序：
         排序====》快排
         不排序===》直接找最大的三位数与最小的两位数

         */
    /*
        quickSort(nums,0,nums.length-1);
        int max3=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int max1min2=nums[nums.length-1]*nums[0]*nums[1];
        return Math.max(max1min2,max3);
    }

    public void quickSort(int[] nums, int start, int end) {
        //出口,只剩1个即为排好序了
        if(start>=end){
            return;
        }
        int pivot=pivot(nums,start,end);
        quickSort(nums, start, pivot-1);
        quickSort(nums, pivot+1, end);
    }
    //找枢轴 那最后一个元素作为数轴来划分该nums，最后划分的结果就是< pivot的在左边，大于的在右边。
    private int pivot(int[] nums, int start, int end) {
        //需要定义两个指针 一个用来遍历 另一个用来指示第一个大于pivot位置的元素
        //第一个大于pivot元素的指针
        int MT=start;
        for(int i=start;i<=end-1;i++){
            if(nums[i]<nums[end]){
                //exchange value with MT,then MT++
                int temp=nums[i];
                nums[i]=nums[MT];
                nums[MT]=temp;
                MT++;
            }
        }
        //exchange the value of end and MT ,then return MT
        int temp=nums[end];
        nums[end]=nums[MT];
        nums[MT]=temp;
        return MT;
    }
    */
    public int maximumProduct(int[] nums) {
        int min1;
        //最小
        int min2;
        int max1;
        int max2;
        //最大
        int max3;


        //未结束
        return 1;
    }
    public static void main(String[] args) {
        MaximumProduct maximumProduct=new MaximumProduct();
        int []nums={-1,3,1,5,-2};
        System.out.println(maximumProduct.maximumProduct(nums));
        System.out.println("======>");
    }
}
