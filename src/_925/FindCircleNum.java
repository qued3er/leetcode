package _925;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/2510:51
 */

//通过并查集实现   如何使用java实现一个并查集？
// 首先考虑java并查集的几个操作   1是union 2是find  其次还要考虑并查集的数据结构。   并查集是由多个根的集合组成的一个DS
// 所以我们可以通过二叉树组成的森林来表示。这样查根的时间复杂度就是树的高度。   也可通过一个数组来表示，数组中的元素的含义
// 是其父元素的下标。
//如果我们使用第一种：那么对于find操作，就是一直向上递归的查找其父节点，对于union操作，  因为是二叉树，所以不能直接
// 和根union 要找一个没左/没右/两者均没的节点，把另一个节点的根当做 当前选出来的节点的孩子。  这样树会增高的很快。所以我们查找
//应该按照层次查找，这样高度上升的慢。
//如果我们使用第二种：我们定义根节点的父亲节点指向它自己，那么对于find操作，我们一直找其值是否与其下标对应。对应则为根。
//对于union操作，把一个根的值指向另一个根。

public class FindCircleNum {
    /**
     * 找朋友圈的个数 a是b的朋友  b是c的  那么a是c的
     * 方法1：通过并查集，最后确定并查集的个数
     *
     * 方法2：通过dfs来确定
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        UnionFind unionFind=new UnionFind(M.length);
        //查一半即可  M[i][j]==1表示互为朋友   所以关于主对角线对称
        for (int i=0;i<M.length;i++){
            for (int j=0;j<i;j++){
                if (M[i][j]==1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count();
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum=new FindCircleNum();
        int [][]M={
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum.findCircleNum(M));
    }
}
//定义一个并查集的数据结构
class UnionFind {

    private int[] id; // 元素存的是该元素的父亲节点的index。  根节点的父节点是他自己
    private int count; // 并查集的根的个数
    private int[] size; //每个根下的元素的个数

    public UnionFind(int N) {
        // Initialize component id array
        count = N;   //初始组的数目为节点个数
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  //初始情况每个节点的组号都是数组的索引
            size[i] = 1; // 初始情况每个组大小都是1
        }
    }

    public int count() {
        return count;
    }
    //给一个元素 找他的根
    public int find(int p) {
        //父亲不是自己  证明还没找到根
        while (p != id[p]) {
            // 将p节点的父节点设置为它的爷爷节点(路径压缩)
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 将小树作为大树的子树(合成树更扁平，减少树的深度)
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}
