package _728;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2818:57
 */
public class SortColors {
    public void sortColors(int[] nums) {
        /*
        分为3个区域 0 区域 1 区域 2 区域
        通过两个指针：
        一个指向0区域最后一个 一个指向2区域的第一个
        从左到右遍历：
        如果当前元素为0，则与left交换，并left++,i++;若为2则与right交换,并right--,并且i++；[注意交换后的i的位置仍需判断至为1]。
        结束条件遍历指针与right碰撞

        注意：由于我们是从左往右扫描，当我们遇到0的时候，与第一个非0交换此时第一个非0元素的index一定在当前i的左边，也就是此时与0
        交换的元素一定是1/与自己交换.交换过的元素一定被扫描过。但当我们扫描到了2时，i一定在最后一个非0元素之前，未扫描过。所以前者需要i++，后者不需要。
        */
        int left=0;
        int right=nums.length-1;
        int i=0;
        while(i<=right){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                i++;
                left++;
            }else if(nums[i]==1){
                i++;
            }else{
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors=new SortColors();
        int [] nums={1,2,0};
        sortColors.sortColors(nums);
        for (int i :
                nums) {
            System.out.print(i);
        }
    }
}
