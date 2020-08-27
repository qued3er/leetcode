package _525;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/5/259:08
 */
public class FloodFill {
        private int old_color,new_color;
        //局部变全局的一个方法
        //使得对image的修改全局可见
        private int [][] target;
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            /**
             采用dfs深度优先遍历(回溯法)

             判断边界条件
             操作
             尝试每一种可能
             */
            if(image[sr][sc]==newColor){
                return image;
            }
            old_color=image[sr][sc];
            new_color=newColor;
            target=image;
            //要能对原image进行修改，修改全局可见
            dfs(sr,sc);
            return image;
        }
        public void dfs(int sr,int sc){
            //相当于同时记录了访问过的点
            target[sr][sc]=new_color;
            //遍历所有可能的情况
            //且if即为出口判断条件
            if(sr>0&&target[sr-1][sc]==old_color){
                dfs(sr-1,sc);
            }
            if(sc>0&&target[sr][sc-1]==old_color){
                dfs(sr,sc-1);
            }
            if(sr<target.length-1&&target[sr+1][sc]==old_color){
                dfs(sr+1,sc);
            }
            if(sc<target[0].length-1&&target[sr][sc+1]==old_color){
                dfs(sr,sc+1);
            }
        }

    public static void main(String[] args) {
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        FloodFill floodFill=new FloodFill();
        floodFill.floodFill(image, 1, 1, 2);

    }

}
