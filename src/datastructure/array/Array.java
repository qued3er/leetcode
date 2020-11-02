package datastructure.array;

import javax.crypto.interfaces.PBEKey;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/10/308:45
 */
//扩容问题与越界问题，好好学习下泛型。

/**
 * 如何在自己的程序中加入泛型使得其可以扩展，从而获得更多的东西？
 * 强转是一个加入泛型的好东西，强转前判断类型。
 *
 * 泛型与通配符的底层到底是怎么实现的？把其底层与其特性结合。
 *
 * 1.为什么说泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的？
 * 2.没有泛型会如何？
 * 原理：类型擦除。
 *
 * java语法糖，javac编译器是如何解除语法糖的？ 看下解语法糖的方法。
 * @param <T>
 */
public class Array<T> {
    private transient Object[] container;
    //指示当前的数组长度
    private int size;
    public Array(){
    }
    public Array(int capacity){
        container=new Object[capacity];
    }
    public void insert(Object entity,int index){
        if (index<0||index>=container.length){
            throw new RuntimeException("数组下标越界");
        }
        if (size==container.length){
            //此时需要扩容，扩容成原来的2倍。注意扩容后需要把原来的数据迁移过去，此时可能要考虑并发问题。
            // ==》暂时先不考虑。
            expansion();
        }
        for (int i=size;i>=index;i--){
            container[i+1]=container[i];
        }
        container[index]=entity;
    }
    //创建一个新的数组。
    private void expansion() {
        //满时才会扩容
        Object[]old=container;
        container=new Object[size*2];
        //迁移
        for (int i = 0; i < size; i++) {
            container[i]=old[i];
        }
    }
    public T get(int index){
        if (index<0||index>size){
            throw new RuntimeException("数组下标越界");
        }
        return (T) container[index];
    }
    public void delete(int index){
        if (index<0||index>=container.length){
            throw new RuntimeException("数组下标越界");
        }
        //后边前移
        for (int i=index;i<size;i++){
            container[index]=container[index+1];
            size--;
        }
    }
    public Integer size(){
        return this.size;
    }
    //common question about array
    //1.Find the second minimum element of an array,via quick sort.
    //可以使用的前提必须是可比较
    public T findSecondMinimumElement(){
        if (!(container instanceof Comparable[])){
            throw new RuntimeException("该实体类型不可比较");
        }
        //avoid disturb original sort.
        Object[] findScope = Arrays.copyOf(container, size);
        //what if length less than 2?

        //the last element as pivot.
        findViaQuickSort(findScope,0,size);
        return (T)findScope[1];
    }

    private void findViaQuickSort(Object[] findScope,int start,int end) {
        //先划分，再递归左右
        //如何做到找到第二就停止？
        int index=getPivot(findScope,start,end);
        if (index==1) {
            return ;
        }
        findViaQuickSort(findScope, start, index - 1);
        findViaQuickSort(findScope, index + 1, end);
    }
    //the last element as pivot.  large than,less than,pivot
    //how to implement compare for this obj===>通过强转
    private int getPivot(Object[] findScope, int start, int end) {
        Object pivot=findScope[end];
        //need two pointer.one is current index,another is first large than[exchange quickly].
        int  firstLargeThan=0;
        //如何实现泛型数据的比较
        for (int i = start; i <end ; i++) {
            //大于0 与firstLargeThan 交换
            if (((Comparable)pivot).compareTo((Comparable)container[i])<0){
                Object temp=container[i];
                container[i]=container[firstLargeThan];
                container[firstLargeThan]=temp;
            }else {
                firstLargeThan++;
            }
        }
        //最后交换
        Object temp=pivot;
        pivot=container[firstLargeThan];
        container[firstLargeThan]=temp;
        return firstLargeThan;
    }
    //2.First non-repeating integers in an array
    //3.Merge two sorted arrays
    //4.Rearrange positive and negative values in an array

}
