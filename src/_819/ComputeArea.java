package _819;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1910:57
 */
//计算出两个矩形的面积和 再减去2倍的重叠面积
    //重叠  纵向：上【d,h】谁小取谁  下[b f]谁大取谁  横向：左[ a  e ]谁大取谁  右：[c  g]谁小取谁
    //重叠的长和宽必须为正
public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=(C-A)*(D-B);
        int area2=(G-E)*(H-F);
        int repeat=0;
        //判断有无重叠
        int up=Math.min(D, H);
        int down=Math.max(B, F);
        int left=Math.max(A, E);
        int right=Math.min(C, G);
        if (up<=down||left>=right){
            return area1+area2;
        }
        repeat=(up-down)*(right-left);
        return area1+area2-repeat;
    }

    public static void main(String[] args) {
        ComputeArea computeArea=new ComputeArea();
        System.out.println(computeArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
