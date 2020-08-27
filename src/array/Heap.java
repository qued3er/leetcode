package array;

/**
 * @author li
 * @Title:
 * @Description: 使用数组来实现大顶堆
 * @date 2020/3/2116:26
 */
public class Heap {
    //对于堆来说，逻辑结构对应的父节点： 一个节点的下标为i，则其左孩子为2i+1,右孩子为2i+2
    private int [] heap;
    //当前对重元素的最后一个数+1
    private int number;
    //堆的构造器相当于创建堆
    public Heap(int size){
        this.heap=new int[size];
        this.number=0;
    }
    //默认构造器，默认为16
    public Heap(){
        this.heap=new int[16];
        this.number=0;
    }

    //实现向堆中插入一个节点,先将其插入数组末尾，然后向上调整
    public void insertNode(int value){
        heap[number]=value;
        //逐步向上调整，与其父比较，如果比其父大就向上调整。儿子的下标为i，父亲的下标为(i-1)/2,至下标为0，小心越界
        int i=number;
        while(i!=0){
            if(heap[i]>heap[(i-1)/2]){
                int temp=heap[i];
                heap[i]=heap[(i-1)/2];
                heap[(i-1)/2]=temp;
            }else{
                break;
            }
        }
        number++;
    }
}
