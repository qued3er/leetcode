package array;

public class Solution3 {
    public int minArray(int[] numbers) {
        // //若采用二分法呢？
        // int min=numbers[0];
        // if(numbers.length>=1){
        // for(int i=0,j=1;j<numbers.length;i++,j++){
        //     if(numbers[j]<numbers[i]){
        //         min=numbers[j];
        //     }
        // }
        // }
        // return min;

        /*由于是部分排序的数组的查找，考虑使用二分法（排序数组的查找  或部分排序数组的查找优先考虑二分法）
        注意到：旋转之后形成了两个排序的数组，左数组的值>右数组的值
        采用二分查找，根据中间的值的大小可判断出该中间值在哪个排序数组中，从而可以判断出旋转点在哪儿.

        采用两个指针p1,p2分别指向前边数组的最小值与后边数组的最大值
        正常情况：
        1.若numbers[mid]>左边数组的最小值，则mid位于左边数组中，则旋转数组的最小值在mid->p2
        2.若numbers[mid]<右边数组的最大值，则mid位于右边数组，则旋转点在p1->mid

        3.考虑特殊情况numbers[mid]=numbers[p1]=number[p2]，[1,0,1,1,1]与[1,1,1,0,1]此时无法判断是在左排序数组还是右排序数组。  此时就直接采用顺序查找。

        特殊情况特殊处理：
        4.考虑只有一个数组的情况【即旋转点等于numbers[0]】。[1,2,3,4,5]

        结束条件 ：p1+1=p2;
        */
        //数组长度若为0，则返回
        if(numbers.length==0){
            return -1;
        }else{
            int p1=0,p2=numbers.length-1;
            int mid=(p1+p2)/2;

            if(numbers[mid]>numbers[p1]&&numbers[mid]<numbers[p2]){
                return numbers[0];
            } else{
                return binarySearch(numbers,p1,p2);
            }
        }
    }

    public int sequentialSearch(int []numbers,int start,int end) {
        int min = numbers[0];
        if (start < end) {
            for (int i = start, j = start + 1; j <= end; i++, j++) {
                if (numbers[j] < numbers[i]) {
                    min = numbers[j];
                }
            }
        }
        return min;
    }



    public int binarySearch(int []numbers,int start,int end){

        int mid=(start+end)/2;
        if((start+1)==end){
            return end;
        }
        //处理仅有一个排序数组的情况
        if(numbers[start]==numbers[end]&&numbers[mid]==numbers[start]) {
            return sequentialSearch(numbers,start,end);
        }
        else if(numbers[mid]>numbers[start]){
            return binarySearch(numbers,mid,end);
        }else{
            return binarySearch(numbers,start,mid);
        }

    }
}
