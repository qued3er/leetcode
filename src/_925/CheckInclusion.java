package _925;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/9/258:25
 */
public class CheckInclusion {
    /**
     * 判断s1的排列是否为s2的子串。
     * 先用dfs求出其全排列再逐个拍段
     *
     * @param s1
     * @param s2
     * @return
     */


    //超内存限制
    private List<String> arrange = new ArrayList<>();

    public boolean checkInclusion(String s1, String s2) {
        char[] s1CharArray = s1.toCharArray();
        StringBuilder track = new StringBuilder();
        boolean[] flag = new boolean[s1CharArray.length];
        backTrack(s1CharArray, track, flag);
        for (String subString :
                arrange) {
            if (s2.contains(subString)) {
                return true;
            }
        }
        return false;
    }

    private void backTrack(char[] s1CharArray, StringBuilder track, boolean[] flag) {
        if (track.length() == s1CharArray.length) {
            arrange.add(track.toString());
        }
        for (int i = 0; i < s1CharArray.length; i++) {
            if (!flag[i]) {
                track.append(s1CharArray[i]);
                flag[i] = true;
                backTrack(s1CharArray, track, flag);
                track.deleteCharAt(track.length() - 1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion=new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("prosperity", "properties"));
        System.out.println('a'+1);
    }
}
