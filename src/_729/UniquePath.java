package _729;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/7/2916:12
 */
public class UniquePath {
        int [][]record;
        public int uniquePaths(int m, int n) {
            /**
             * 通过回溯法
             * m行n列
             * 备忘录==》来优化即在递归前先查找如果有值就通过加 如果无值就递归找
             * 加上了障碍物
             */
            record = new int[m][n];
            return getAllPath(0,0);
        }

        private int getAllPath(int row, int column) {
            if (row==record.length-1||column==record[0].length-1){
                return 1;
            }
            if (record[row][column]!=0){
                return  record[row][column];
            }
            record[row][column]=getAllPath(row+1, column)+getAllPath(row, column+1);
            return record[row][column];
        }

    /*动态规划：
    * */
    /*public int uniquePaths(int m, int n) {
        int [][]record=new int[m][n];
        //record[i][j]表示从[i,j]到fin的路径数
        //初始化最后一行 与最后一列为1
        for (int i=0;i<m;i++){
            record[i][n-1]=1;
        }
        for (int i=0;i<n;i++){
            record[m-1][i]=1;
        }
        //当且仅当右部和下部有具体指才可以产生当前的路径数==》所以从右向左从下至上
        for (int i=m-2;i>=0;i--){
            for (int j=n-2;j>=0;j--){
                record[i][j]=record[i+1][j]+record[i][j+1];
            }
        }
        return record[0][0];
    }
    */
    public static void main(String[] args) {
        UniquePath uniquePath=new UniquePath();
        long startTime=System.currentTimeMillis();
        System.out.println(uniquePath.uniquePaths(7, 3));
        long endTime=System.currentTimeMillis();
        System.out.println("spendTime: "+(endTime-startTime));
    }
}
