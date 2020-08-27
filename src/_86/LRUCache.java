package _86;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/69:53
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU特性：当满时删除最近没有用过的。 所以需要维持使用的顺序。===》DS：HashMap+双向列表[删除要知道前驱]
 * HashMap<Integer,Node>
 *     node要同时保存key/value，因为我们满了删除最近未使用时仅知道node节点，若仅存value，则无法从map中删除对应的key/value
 * get:从HashMap找，找到就返回其值，并需要更新双向链表，即将值对应的节点从当前位置删除，放在头部。[遇到问题：无法满足O(1)复杂度]
 * 因为根据值遍历找链表O(n)。所以我们把Map的value存为指向节点的指针，这样就可直接锁定在双向链表中需要修改的节点的指针。达到O(1)。
 * 找不到返回-1.
 * put：如果包含该元素，那么就更新指向的node并把该节点移到头部，如果不包含，需要看cache是否满了，如果是就需要移除尾部的并且从cache
 * 中删除对应的key，value并且将新的put并加入头部*/
class Node{
    Node pre;
    Node next;
    int key;
    int value;
    Node(){}
    Node(int key,int value,Node pre,Node next){
        this.key=key;
        this.value=value;
        this.pre=pre;
        this.next=next;
    }
}
public class LRUCache {
    //伪头部与伪首部
    Node head=new Node();
    Node tail=new Node();
    Map<Integer,Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>(capacity);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            Node modifyNode=cache.get(key);
            //完成从对应位置移除
            Node reNode=removeNodeInList(modifyNode);
            //插入头部
            insertInhead(reNode);
            return modifyNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node modifyNode=cache.get(key);
            //修改其值
            modifyNode.value=value;
            //完成从链表中对应位置移除
            Node reNode=removeNodeInList(modifyNode);
            //插入头部
            insertInhead(reNode);
        }
        //不含有该映射    如果不用else  则当可能经过上边的if在上边if更新后，删除更新后的
        else {
            if (cache.size()==capacity){
                //移除,并且需要从cache中删除
                Node removeNode = removeNodeInList(tail.pre);
                //在这儿对之前的节点进行了remove但是没有去除？====》原因：键值对不是相同的元素==>问题就变为了如何根据值去删除对应的键值对
                //如果有同值不同键的元素呢？==》解决办法：Node中同时保存键与值。
                cache.remove(removeNode.key);
                //插入新节点到头部
            }
        //不含有映射且未满，直接创建洗节点到头部并放入cache
        //做了代码合并优化
        Node newNode=new Node();
        newNode.key=key;
        newNode.value=value;
        insertInhead(newNode);
        cache.put(key, newNode);
        }
    }

    private void insertInhead(Node newNode) {
        head.next.pre=newNode;
        newNode.next=head.next;
        head.next=newNode;
        newNode.pre=head;
    }

    private Node removeNodeInList(Node modifyNode) {
        Node temp=modifyNode;
        modifyNode.pre.next=modifyNode.next;
        modifyNode.next.pre=modifyNode.pre;
        return temp;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.get(2);       // 返回  1
        cache.put(2, 6);
//        cache.put(2, 2);
//        cache.put(3, 2);    // 该操作会使得关键字 2 作废
        cache.get(1);
        cache.put(1, 5);    // 该操作会使得关键字 1 作废
        cache.put(1, 2);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
//        cache.get(4);       // 返回  4
    }
}
