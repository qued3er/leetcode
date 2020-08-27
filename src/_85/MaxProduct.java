package _85;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/510:25
 */
public class MaxProduct {
    /*
    * 动态规划：通过1个数组来完成
    * endIndex与maxValue：endIndex[i]用来指示0->j的最大值的end，maxvalue[i]用来指示0->j乘积的最大值
    * 状态转移方程:
    * i=j,endIndex[0]=i,maxValue[0]=nums[0]
    * i!=j,endIndex[i]根据maxValue取到的最大值 决定是延续还是修改,
    * maxValue[i]=max(maxValue[i-1]*nums[i],maxValue[i-1],s[i]) 当endIndex[i]=i-1
    * max(maxValue[i],s[i])当endIndex[i-1]!=i-1时。
    *
    * */
    public int maxProduct(int[] nums) {
        int length=nums.length;
        int []endIndex=new int[length];
        int []maxValue=new int[length];
        int []minValue=new int[length];
        //初始化
        endIndex[0]=0;
        maxValue[0]=nums[0];
        for (int i=1;i<length;i++){
            if (nums[i]>=0){
            if(endIndex[i-1]==i-1){
                int max=Math.max(Math.max(maxValue[i-1]*nums[i],nums[i]),maxValue[i-1]);
                //endIndex不用更新
                if (max==maxValue[i-1]){
                    endIndex[i]=endIndex[i-1];
                }else {
                    endIndex[i]=i;
                }
                maxValue[i]=max;
            }else {
                int max=Math.max(maxValue[i-1],nums[i]);
                if (max==nums[i]){
                    endIndex[i]=i;
                }else {
                    endIndex[i]=i-1;
                }
                maxValue[i]=max;
            }
            }else {
                //待完成
            }
        }
        return maxValue[length-1];
    }

    public static void main(String[] args) {
        MaxProduct maxProduct=new MaxProduct();
        int []nums={-2,1,-1};
        System.out.println(maxProduct.maxProduct(nums));
    }
}
