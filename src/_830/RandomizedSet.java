package _830;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author li
 * @Title:
 * @Description:
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * O(1)判断该元素是否存在====》hash表，
 * 关键在于如何达到随机返回一个元素且概率相等？
 * 一般的想法是通过random一个随机的索引值，返回该索引对应的值。==》通过数组,考虑到扩容使用arraylist。
 * 则我们通过一个hashmap来存储key:value 值：值在Arraylist中的下标。
 * 通过hashmap来实现O(1)的查找 通过arraylist来实现O(1)的返回一个随机元素，之间的关联有map的value存储值对应的index。
 * @date 2020/8/30  19:51
 */
public class RandomizedSet {
    private Map<Integer, Integer>dict;
    private List<Integer> randList;
    private int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict=new HashMap<>();
        randList=new ArrayList<>();
        size=0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)){
            return false;
        }
        dict.put(val, size);
        if (randList.size()>size) {
            randList.set(size, val);
        }else {
            randList.add(val);
        }
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.
     * 在remove的时候，由于对index做了改变所以同时需要修改dict的value
     * 只有一个元素时remove有问题。
     * 先size--，先交换 后remove
     * */
    public boolean remove(int val) {
        if (!dict.containsKey(val)){
            return false;
        }
        int index=dict.get(val);
        size--;
        //先交换 再size--
        randList.set(index, randList.get(size));
        dict.put(randList.get(index), index);
        dict.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
       return randList.get(new Random().nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedSet randomSet=new RandomizedSet();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomSet.remove(0);

// 返回 false ，表示集合中不存在 2 。
        randomSet.remove(0);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomSet.insert(0);

// getRandom 应随机返回 1 或 2 。
        randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomSet.remove(0);

// 2 已在集合中，所以返回 false 。
        randomSet.insert(0);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//        randomSet.getRandom();
    }
}
