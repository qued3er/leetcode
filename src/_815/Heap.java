package _815;

import java.util.ArrayList;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1518:09
 */
//大根堆
public class Heap {
    private ArrayList<Integer> heap;
    Heap(int []nums){
        heap=new ArrayList<>(nums.length);
        buildHeap(nums);
    }
    //将一个节点插入当前的尾部 向上调整至大于其父 如果当前的节点的下标为i那么其父的下标(i-1)/2
    public void buildHeap(int[] nums) {
        heap.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            insertNode(nums[i]);
        }
    }
    //插入节点 插入到尾部 向上调整
    public void insertNode(int value){
        heap.add(value);
        for (int i = heap.size()-1; i >=0 ;) {
            int parent=(i-1)/2;
            if (heap.get(i)>heap.get(parent)){
                //交换 父子 新父为子
                exchange(i,(i-1)/2);
                i=(i-1)/2;
            }else {
                break;
            }
        }
    }

    private void exchange(int index1, int index2) {
        int temp=heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    //这儿的removenode是获得当前最大的元素 堆顶
    public int removeNode(){
        exchange(0, heap.size()-1);
        int max = heap.remove(heap.size() - 1);
        //向下调整 与两个孩子最大的交换  节点下标为i 则其孩子为2*i+1  2*i+2  调整的底就是其孩子超出了当前堆的size
        int i=0;
        //有孩子
        while ((2*i+1)<=heap.size()-1){
            //仅有左
            if ((2*i+1)==heap.size()-1){
                if (heap.get(i)<heap.get(2*i+1)){
                    exchange(i, 2*i+1);
                }
                break;
            }else {
            //左右都有 与大的那个交换
                int maxChildrenIndex=heap.get(2*i+1)>heap.get(2*i+2)?2*i+1:2*i+2;
                if (heap.get(maxChildrenIndex)>heap.get(i)){
                    exchange(maxChildrenIndex, i);
                    i=maxChildrenIndex;
                }else {
                    break;
                }
            }

        }
        return max;
    }
}
