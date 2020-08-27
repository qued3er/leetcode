package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2911:12
 */
/**
 * 如何做到找到第k个就break？
 *
 * */
public class GetPermutation {
    //使用一个flag来 标志是否找到第k个 实现早结束
    boolean flag=false;
    //使用一个全局的变量来指向最终结果
    StringBuilder res;
    int sx;
    public String getPermutation(int n, int k) {
        sx=k;
        StringBuilder stringBuilder=new StringBuilder(k);
        int []nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i+1;
        }
        int [] used=new int[n];
        backtrack(nums,stringBuilder,used);
        return res.toString();
    }

    private void backtrack(int[] nums, StringBuilder stringBuilder,int[]used) {
        if (stringBuilder.length()>=nums.length){
            sx--;
            if (sx==0){
                flag=true;
                res=new StringBuilder(stringBuilder);
            }
            return;
        }
        if (!flag) {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 1) {
                    continue;
                }
                stringBuilder.append(nums[i]);
                used[i] = 1;
                backtrack(nums, stringBuilder, used);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                used[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        GetPermutation getPermutation=new GetPermutation();
        System.out.println(getPermutation.getPermutation(3, 3));
    }
}
