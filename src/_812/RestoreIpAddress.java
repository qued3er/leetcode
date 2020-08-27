package _812;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1210:37
 */
//划分点的确定：一个IP有四个segment，逐个的确定每一个segment。确定时需要早退出一些不满足要求的segment。
//不满足的情况：剩下的>segment的个数*3   剩下的等于3并且
public class RestoreIpAddress {
    List<String>res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] target = s.toCharArray();
        StringBuilder track=new StringBuilder();
        findAllSegment(0,0,target,track);
        return res;
    }
//寻找第segment的片段的所有的满足要求的可能值 加入track。 回溯时remove出track
    private void findAllSegment(int segment, int segStart, char[] target, StringBuilder track) {
        if (segment==4&&segStart!=target.length){
            return;
        }
        //小心数组越界 当剩下的长度不足以到2,3的时候  就不能
        //segment==0并且剩余的为0 就添加
        if (segment==4&&segStart==target.length){
            res.add(track.toString());
        }
        //长度最多为3
        for (int i=segStart;i<segStart+3;i++){
            int value=0;
            for (int j=segStart;j<=i;j++){
                track.append(target[j]);
                value=value*10+target[j]-'0';
            }
            track.append('.');
            //剔除不满足要求的点
            //1.剩余长度>剩下的segment*3
            //2.segStart位置的元素为0，则该segment只能为0
            //3.>255
//            if (value<=255&&)
            findAllSegment(segment+1, i+1, target, track);
            //回溯
            track.delete(segStart, track.length());
        }
    }

    public static void main(String[] args) {
        String IP="25525511125";
        RestoreIpAddress restoreIpAddress=new RestoreIpAddress();
        restoreIpAddress.restoreIpAddresses(IP);
    }
}
