package _815;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1516:38
 */
//找数组排序后的第k大元素，使用快速排序的partition来解决
    //拿最后一个做枢轴进行划分   如果当前是k 则返回 如果当前返回的<k，那么就去后边找
    //绝对能找到
    //傻逼了  是第k个最大的 不是第k大
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int start=0;
        int end=nums.length-1;
        //第k个最大的元素不等于第k大
        k=nums.length-k;
        while (start<end){
            int index=partition(nums, start, end);
            if (index==k){
                return nums[index];
            } else if (index<k) {
                start=index+1;
            }else {
                end=index-1;
            }
        }
        return nums[start];
    }
    //对start->end的进行partition
    private int partition(int[] nums, int start, int end) {
        int pivot=nums[end];
        int largeThanPivotFirst=start;
        for (int i=start;i<end;i++){
            if (nums[i]<pivot) {
                exchange(nums,i,largeThanPivotFirst);
                largeThanPivotFirst++;
            }
        }
        exchange(nums,end,largeThanPivotFirst);
        return largeThanPivotFirst;
    }

    private void exchange(int[] nums, int num1, int num2) {
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;
    }

    public static void main(String[] args) {
        int []nums={3,2,3,1,2,4,5,5,6};
        FindKthLargest findKthLargest=new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, 4));
    }
}
