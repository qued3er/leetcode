package _528;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/289:41
 */
public class WaysToStep {
    int result;
    public int waysToStep(int n) {
        /**
         递归   与   迭代
         */
        /**
        //迭代，需要有三个值  f(4)=f(1)+f(2)+f(3)
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
//        初始化为f(1)f(2)f(3)
        int pre=1;
        int mid=2;
        int suc=4;
        for(int i=4;i<=n;i++){
            //如果直接对三个的和取模，三个的和可能会溢出变为负数，即都是1000000007附近的，由于两个1000000007相加不会
            //溢出所以，先对两个的和取模，再与第三个相加，再取模。
            int temp=((pre+mid)%1000000007+suc)%1000000007;
            pre=mid;
            mid=suc;
            suc=temp;
        }
        return suc;
         */
//        递归
        return  findNResult(n);
    }

    private int findNResult(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }

        return ((findNResult(n-1)+findNResult(n-2))%1000000007+findNResult(n-3))%1000000007;
    }
    /*递归效率太低 需要一直开辟栈 */
    public static void main(String[] args) {
        WaysToStep waysToStep=new WaysToStep();
        System.out.println(waysToStep.waysToStep(38));
    }
}
