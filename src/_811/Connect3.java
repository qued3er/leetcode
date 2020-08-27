package _811;

import _810.Connect;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/118:14
 */
/*优化：把第一层看成已经处理过next的，然后可以根据：第n-1层已经按照next有序串起来了，那么在遍历第n-1层时，可以依据他的顺序把第
* n层的串起来。
* 我们之前使用队列是因为需要保存下一层的顺序，而现在由于上一层已经经过next指针串接。从而下一层的顺序也就可以根据上一层来做。
* 节省空间复杂度
* 如何跳层？
* 在给下一层串接next的时候记录其第一个节点。*/
public class Connect3 {
    public Node connect3(Node root){
        Node leftMost=root;
        //结束点：下一层没有首节点
        Node sentry=new Node();
        //跳出循环的判断条件应该是 leftmost没更改
        while (leftMost!=null) {
            Node cur=leftMost;
            Node pre=sentry;
            //遍历当前层的链表,链接其子节点
            //cur有左且有右，则之前的pre的next指向当前左，当前左的next指向当前右。pre=当前右
            //cur仅有左，....pre=当前左
            //cur仅有右....pre=当前右
            //无左无右...donothing
            while (cur != null) {
                //如何维护leftmost   当pre为空时的cur不为空的第一个节点就为leftMost
                //没孩子就没更新
                if (pre==sentry){
                    if (cur.left!=null){
                        leftMost=cur.left;
                    }else if (cur.right!=null){
                        leftMost=cur.right;
                    }else {
                        leftMost=null;
                    }
                }
                //构建当前节点的子女
                //还会左右都不为空呢
                if (cur.left!=null&&cur.right!=null){
                    pre.next=cur.left;
                    cur.left.next=cur.right;
                    pre=cur.right;
                }else if (cur.left!=null&&cur.right==null){
                    pre.next=cur.left;
                    pre=cur.left;
                }else if (cur.left==null&&cur.right!=null){
                    pre.next=cur.right;
                    pre=cur.right;
                }
                cur=cur.next;
            }
        }
        return root;
    }

}
