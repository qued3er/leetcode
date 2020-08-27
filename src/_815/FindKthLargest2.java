package _815;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1517:29
 */
//使用堆排序找第k大元素
// 堆用数组来表示，操作包括建堆，删除节点、插入节点。
public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        Heap heap=new Heap(nums);
        for (int i = 1; i <= k-1; i++) {
            heap.removeNode();
        }
        return heap.removeNode();
    }

    public static void main(String[] args) {
        int []nums={3,2,1,5,6,4};
        FindKthLargest2 findKthLargest2=new FindKthLargest2();
        System.out.println(findKthLargest2.findKthLargest(nums, 3));
    }
}
