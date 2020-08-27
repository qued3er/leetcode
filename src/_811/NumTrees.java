package _811;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/119:27
 */
public class NumTrees {
    /*1-n能组成的二叉搜索树的个数

    * 递归：
    * 求n个有序的数所有二叉搜索树的个数，等于1-n每个做根的种数加起来。
    * 假设前者表示为g(n)【长度为n的有序数能生成的种类数】,后者表示为 f(i,n)[i=1-n]    f(i,n)表示以第i为根，n个数的二叉搜索树的个数。
    * 【需要注意的是n是个数，也就是说，1-3 与3-6种类数没差别。】
    * 很容易想到  构造是递归的：
    * f(i,n)=g(i-1)*g(n-i)左的种类数x右的种类数
    * g(n)=g(i-1)*g(n-i)[i=1->n] =====>递归式*/
    public int numTrees(int n) {
        int []g=new int[n+1];
        g[0]=1;
        g[1]=1;
        for (int i = 2; i <=n ; i++) {
            int sum=0;
            for (int j=1;j<=i;j++){
                sum=g[j-1]*g[i-j]+sum;
            }
            g[i]=sum;
        }
        return g[n];
    }
    public static void main(String[] args) {
        NumTrees numTrees=new NumTrees();
        long start=System.currentTimeMillis();
        System.out.println(numTrees.numTrees(20));
        System.out.println("迭代时间\t:"+(System.currentTimeMillis()-start));
        NumTrees2 numTrees2=new NumTrees2();
        long start1=System.currentTimeMillis();
        System.out.println(numTrees2.numTrees(20));
        System.out.println("递归时间\t:"+(System.currentTimeMillis()-start));
    }
}
