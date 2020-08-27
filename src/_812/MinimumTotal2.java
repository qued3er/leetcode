package _812;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/129:28
 */
//动态规划：后边的value取决的前边的value，所以在找状态转义方程的时候，以后边的为基准找其余前边的联系
//使用动态规划求三角形的最小值,基于某个点的最小值来自于前一行的相同位置或前一位置加自己的value使用一个List<List<Integer>>
// 来记录到某个点的最短距离是多少，底为初始化第一行与第二行
public class MinimumTotal2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //索引值
        int maxColumn=triangle.size();
        int maxRow=triangle.get(maxColumn-1).size();
        int [][]minValue=new int[maxColumn][maxRow];
        minValue[0][0]=triangle.get(0).get(0);
        for (int i=1;i<maxColumn;i++){
            minValue[i][0]=minValue[i-1][0]+triangle.get(i).get(0);
            for (int j=1;j<triangle.get(i).size()-1;j++){
                //更新
                int min=Math.min(minValue[i-1][j],minValue[i-1][j-1]);
                minValue[i][j]=min+triangle.get(i).get(j);
            }
            //更新最後一個
            int lastIndex=triangle.get(i).size()-1;
            minValue[i][lastIndex]=minValue[i-1][lastIndex-1]+triangle.get(i).get(lastIndex);
        }
        int min=minValue[minValue.length-1][0];
        //求最後一行的最小值
        for (int i=1;i<minValue[minValue.length-1].length;i++){
            if (min>minValue[minValue.length-1][i]){
                min=minValue[minValue.length-1][i];
            }
        }
        return min;
    }
}
