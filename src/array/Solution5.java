package array;

public class Solution5 {
    /*创建一个m行n列的数组，用来标识是否被累加过了。 flag
然后从(0,0)开始扩散，判断与其相邻的且未被标记的格子的位数之和是否满足<=k的条件

(i,j)=上下左右能到的位置+1
*/
    public int movingCount(int m, int n, int k) {
        if(m==0||n==0||k<=0){
            return 0;
        }
        int[][] flag = new int[m][n];
        return numberOfCell(flag, 0, 0, k);
    }
    public int numberOfCell(int [][]flag,int line,int row,int k){
        if(line<0||line>flag.length-1||row<0||row>flag[0].length-1||checkK(line,row,k)){
            return 0;
        }
        flag[line][row]=1;
        return 1+numberOfCell(flag,line-1,row,k)+numberOfCell(flag,line+1,row,k)+numberOfCell(flag,line,row-1,k)+numberOfCell(flag,line,row+1,k);
        //写一个判断位数之和的方法。
    }
    public boolean checkK(int line,int row,int k){
        if(getDigit(line)+getDigit(row)<k){
            return true;
        }
        return false;
    }
    public int getDigit(int number){
        int sum=0;
        while(number>0){
            sum=number%10;
            number=number/10;
        }
        return sum;

    }

}
