package _822;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/2221:06
 */
//思路： 之前我们求只有一个元素不是出现2次的时候  使用异或 最后的得到即为想要的数字。
    // 而现在异或了之后不是  那么我们能不能转换成之前的即把相同的数字+1个单独的出现的元素分为1组，从而分为2组
    //就可以分别对这两个组使用之前的算法 就可以得到结果了。
    //如何划分？
    //通过位  首先根据最后一位进行划分 0一组 1一组    相同元素一定一组   如果划分后两组都不为0 证明两个单独出现的
    //划分到一个组里去了， 如果一个为0  证明 两个元素在两一个组。那么我们在提高一位 用上一位进行划分，直至两个组都
    //不为0.
    //如果不重复的数字有一个0呢？


//还可以进一步优化
    //能否提前确定 只出现一次的数字 哪些位不一样呢？
    //我们可以先对所有的数字进行一次异或  相同的抵消为0  0 与任何数字异或都是他自己   其实就相当于对两个出现一次的数字
    //进行了异或，找到一位结果为1 ，拿着哪个位去划分  然后对划分后的结果异或  得到的一定是 两个不同的数字
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int index=0;
        int []res=new int[2];
        //对某个集合的数字按照某一位进行划分 最后一个0表示倒数第一位
        //返回划分后的第二个数组的起始
        while ((left+1)<right){
            int start=partition(nums,left,right,index);
        //对划分后的结果分别进行异或
            int res1=xorArray(nums,left,start-1);
            int res2=xorArray(nums,start,right);
            if ((start-left)%2==1||(res1!=0&&res2!=0)){
                res[0]=res1;
                res[1]=res2;
                return res;
            }else if (res1==0){
                //对右半部分继续
                left=start;
            }else {
                //对左半部分继续
                right=start-1;
            }
            index++;
        }
        res[0]=nums[left];
        res[1]=nums[right];
        return res;
    }

    private int xorArray(int[] nums, int left, int right) {
        int res=0;
        for (int i=left;i<=right;i++){
            res^=nums[i];
        }
        return res;
    }

    private int partition(int[] nums, int left, int right, int index) {
        //维持一个0的最后一位的下一位
        int first1=left;
        //左0右1
        for (int i=left;i<=right;i++){
            int value=nums[i]>>index;
            if (value%2==0){
                //最后一位为0
                //与first1交换 然后first1++
                int temp=nums[i];
                nums[i]=nums[first1];
                nums[first1]=temp;
                first1++;
            }
        }
        return first1;
    }

    public static void main(String[] args) {
        int []nums={-1638685546,-2084083624,-307525016,-930251592,-1638685546,1354460680,623522045,-1370026032,
                -307525016,-2084083624,-930251592,472570145,-1370026032,1063150409,160988123,1122167217,1145305475,
                472570145,623522045,1122167217,1354460680,1145305475};
        SingleNumber singleNumber=new SingleNumber();
        singleNumber.singleNumber(nums);
    }
}
