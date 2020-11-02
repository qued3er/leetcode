package _1027;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/10/2713:55
 */
public class ValidUTF82 {
    //确定起始状态0为clear状态，状态0为符合UTF8编码的状态。
    //然后确定状态0状态转移：可接受0xxxxxxx,110xxxxx,1110xxxx,11110xxx.分别到达状态0,1,2,3
    //状态1只能接受10xxxxxx到达状态0.
    //状态2接受10xxxxxx到达状态4,4接受10xxxxxx到达状态0
    //状态3接受10xxxxxx到达状态5,5接受10xxxxxx到达状态6,6接受10xxxxxx到达状态0.
    static final int TYPE_0=0B00000000;
    static final int TYPE_1=0B10000000;
    static final int TYPE_2=0B11000000;
    static final int TYPE_3=0B11100000;
    static final int TYPE_4=0B11110000;
    //当前状态key  value可接受与与接受后对应状态的映射
    static final Map<Integer,Map<Integer,Integer>> DFA=new HashMap<>();
    static final int[] mask=new int[]{TYPE_4,TYPE_3,TYPE_2,TYPE_1,TYPE_0};
    static {
        DFA.put(0, new HashMap<Integer,Integer>(){{
            put(TYPE_0, 0);
            put(TYPE_2, 1);
            put(TYPE_3, 2);
            put(TYPE_4, 3);
        }});
        DFA.put(1, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 0);
        }});
        DFA.put(2, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 4);
        }});
        DFA.put(3, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 5);
        }});
        DFA.put(4, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 0);
        }});
        DFA.put(5, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 6);
        }});
        DFA.put(6, new HashMap<Integer,Integer>(){{
            put(TYPE_1, 0);
        }});
    }
    public boolean validUtf8(int[] data) {
        int curState=0;
        //如果经过data到达状态0，那么表示该data符合UTF8编码。
        for (Integer code:
             data) {
            if (code>247){
                return false;
            }
            Integer next=getNext(code,curState);
            if (next==null){
                return false;
            }
            curState=next;
        }
        return curState==0;
    }
    //依据当前的状态与当前的编码看有无相同出边到达下一个状态。
    private Integer getNext(Integer code,Integer curState) {
        Map<Integer, Integer> map = DFA.get(curState);
        //5个1 11111
        //逐个判断有无符合的TYPE 有就到达他的下一个状态
        for (int value : mask) {
            if ((value & code) == value) {
                return map.get(value);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ValidUTF82 validUTF82=new ValidUTF82();
        System.out.println(validUTF82.validUtf8(new int[]{248,130,130,130}));
    }
}

