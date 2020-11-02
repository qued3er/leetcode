package _923;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/228:26
 */
public class CompareVersion {
    /**
     * version仅包括数字与. 1>2返回1 1<2返回-1 1=2返回0
     * 首先将两个version补齐，然后逐个的跳过小数点对比 从左往右 遇到<或 >就返回1/-1 比完就返回0
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String []v1Array=version1.split("\\.");
        String []v2Array=version2.split("\\.");
        for (int i=0;i<v1Array.length&&i<v2Array.length;i++){
            int v1=Integer.parseInt(v1Array[i]);
            int v2=Integer.parseInt(v2Array[i]);
            if (v1<v2){
                return -1;
            }
            if (v1>v2){
                return 1;
            }
        }
        //当长度不一样时  还需要比较剩下的
        if (v1Array.length==v2Array.length) {
            return 0;
        }else if (v1Array.length<v2Array.length){
            for (int i=v1Array.length;i<v2Array.length;i++){
                //不能是等于1 个0 剩余的
                if (!(Integer.parseInt(v2Array[i])==0)){
                    return -1;
                }
            }
            return 0;
        }else {
            for (int i=v2Array.length;i<v1Array.length;i++){
                if (!(Integer.parseInt(v1Array[i])==0)){
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        CompareVersion compareVersion=new CompareVersion();
        System.out.println(compareVersion.compareVersion("19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
        ));
    }
}
