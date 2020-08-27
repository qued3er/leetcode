package _528;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/2810:31
 */
public class PathWithObstacles {
    List<List<Integer>> result=new ArrayList<>();
    boolean flag;
    int row;
    int col;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        /**
         回溯法：
         */
        //temp现在已经走到哪儿了
        //index为0的地方是横坐标 index为1的地方是纵坐标
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        temp.add(0);
        //初始化传入0,0
        findPath(obstacleGrid,temp);
        if(flag==true) {
            return result;
        }else {
            return new ArrayList<>();
        }
    }
    //只找到一条即可
    //temp是一个对象 在结果中存的只是指向temp的索引。
    private void findPath(int[][] obstacleGrid, List<Integer> temp) {
        List<Integer> step=new ArrayList<>();
        step.add(temp.get(0));
        step.add(temp.get((1)));
        result.add(step);
        //出口1 向右或者向下都不能走  回退 需要记录从哪儿过来的

        if(obstacleGrid[temp.get(0)+1][temp.get(1)]==1&&obstacleGrid[temp.get(0)][temp.get(1)+1]==1){
//            if(row+1==)
        }
        //出口2 到达右下角
        if (temp.get(0)==obstacleGrid.length-1&&temp.get(1)==obstacleGrid[0].length-1){
            flag=true;
            return ;
        }

        //向下
        if(temp.get(0)<obstacleGrid.length-1&&obstacleGrid[temp.get(0)+1][temp.get(1)]==0&&flag==false){
            row=temp.get(0);
            temp.remove(0);
            temp.add(0, row+1);
            findPath(obstacleGrid, temp);
            //回溯
//            temp.remove(0);
//            temp.add(0, row);
//            result.remove(result.size()-1);
        }
        //向右
         if(temp.get(1)<obstacleGrid[0].length-1&&obstacleGrid[temp.get(0)][temp.get(1)+1]==0&&flag==false){
            col=temp.get(1);
            temp.remove(1);
            temp.add(1, col+1);
            findPath(obstacleGrid, temp);
            //回退
//            temp.remove(1);
//            temp.add(0, col);
//             result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        PathWithObstacles pathWithObstacles=new PathWithObstacles();
        //不会回退
//        int [][]obstacles={{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//                {0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
//                {1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},
//                {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
//                {0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},
//                {1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
//                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},
//                {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
//                {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
//                {1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},
//                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},
//                {0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},
//                {0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},
//                {1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},
//                {0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},
//                {0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},
//                {1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},
//                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
        int [][]obstacles={{0,0,0,0,0},
                            {0,0,0,0,1},
                            {0,0,0,1,0},
                            {0,0,1,0,0}};
        pathWithObstacles.pathWithObstacles(obstacles);
        System.out.println("=======>");
    }
}
