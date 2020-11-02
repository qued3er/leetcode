package _922;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/238:47
 */

/**
 * 水壶问题
 * 两个水壶  一个 x  一个y  能否用他俩得到z升的水
 * 一直 x  y  |x-y|
 * 请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 问题转变为  x y |x-y|能否组成1个z
 * x==z
 * y==z
 * |x-y|==z
 * x+y==z
 * x+|x-y|==z
 * y+|x-y|==z
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y<z){
            return false;
        }
        //待定
        return false;
    }
}
