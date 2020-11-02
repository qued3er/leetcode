package _1028;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/10/2815:47
 */

/**
 * 堆：分为小顶堆和大顶堆。===>相当于一个完全二叉树.
 * 以大顶堆为例:
 *      大顶堆的特性：父节点值大于其两个子节点的值。[注意：是递归定义的。==》所以对于一格堆那么堆顶就是该堆最大的值。]
 *      大顶堆的查找：[优点在于每次查最大/最小值的时间复杂度为O(nlgN),因为相当于完成一次构建，要堆顶。]但是当查的是非最大/最小时O(n)
 *      大顶堆的新增：时间复杂度Olgn，直接插在尾部，然后逐步向上调整。
 *      大顶堆的删除：首先与最后一个节点交换，然后删除掉最后一个节点，向上调整。
 *      大顶堆的构建：按照新增进行插入。
 * 堆使用的场景及其优点：
 *      ==》用于堆排序，首先构建nlgn，然后逐个移除最大/最小nlgn。所以对排序的时间复杂度为nlgn  ===》
 *      拿前几的数据是有优势的，clgn。
 *      需要考虑的一个问题：使用什么存储？
 *      如果使用数组：那么如何扩充？[当数据满了重新建一次堆]
 *      ==》扩充为原1.5倍的容量。
 */
public class Heap<T> {
    //用来存储数据的容器
    private T [] container;
    //指示当前堆内已用数据的大小。
    private int count;
    public Heap() {
    }
    //指定容量的构造器
    public Heap(int count) {
        this.count = count;
    }
    //
    public Heap(T[]container){

    }
}
