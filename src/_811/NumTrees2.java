package _811;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1111:24
 */
/*递归：
* g(n)=g(i-1)*g(n-i)[i=1->n]*/
public class NumTrees2 {
    public int numTrees(int n) {
        if (n==0||n==1){
            return 1;
        }
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
}
