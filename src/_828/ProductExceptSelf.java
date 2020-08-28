package _828;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/287:56
 */
//在包含状态转移且当前元素的value取决于其前边所有元素的value，这时要考虑使用前缀数组。
    //空间复杂度为O(n)的方法，使用一个前缀数组与一个后缀数组l[i]*r[i]就为当前的值。 l与r预处理，后一个元素的值等于前一个元素的值*nums[i]
    //空间复杂度为O（1）利用answer数组[结果数组不在空间复杂度考虑范围内]，先把l数组初始化到answer，再用一个值动态表示R数组从右向左计算。
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length==0){
            return nums;
        }
        int[]res=new int[nums.length];
        res[0]=1;
        //初始化res为l数组
        for (int i = 1; i < res.length; i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        int right=1;
        for (int i = res.length-1; i >=0 ; i--) {
            res[i]=res[i]*right;
            right=right*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={1,2,3,4};
        ProductExceptSelf productExceptSelf=new ProductExceptSelf();
        productExceptSelf.productExceptSelf(nums);
    }
}
