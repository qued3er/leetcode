package _527;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/2710:19
 */
public class MagicIndex {
    /**
     * 寻找满足A[i]=i的最小索引值
     * */
    /**
     * 法1：跳转查找
     *
     * 法2：采用二分查找。
     *
     *  先找中间，如果中间的为A[i]=i,则往只能往左边找，如果A[i]!=i,则先去左边找，在左边找不到的时候再去右边找。
     *
     * */
    int result=-1;
    public int findMagicIndex(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]>i){
//                //即将要i++
//                i=nums[i]-1;
//            }else if(nums[i]==i){
//                return i;
//            }
//        }
//        return -1;
        binarySearch(nums,0,nums.length-1);
        return result;
    }

    private void binarySearch(int[] nums, int start, int end) {
        //出口
        if(start>end){
            return;
        }
        int mid=(start+end)/2;
        if(nums[mid]==mid){
            if(result==-1){
                result=mid;
            }else{
                if(result>mid){
                    result=mid;
                }
            }
            binarySearch(nums, start, mid-1);
        }else{
            binarySearch(nums, start, mid-1);
            binarySearch(nums, mid+1, end);
        }
    }

    public static void main(String[] args) {
        MagicIndex magicIndex=new MagicIndex();
        int [] nums={0,0,2};
        System.out.println(magicIndex.findMagicIndex(nums));
    }
}
