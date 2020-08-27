package _67;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/6/77:24
 */
public class LetterCombinations {
    Map<Character,String> phone=new HashMap<Character, String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9', "wxyz");
    }
    };
    private List<String> result=new ArrayList<>();
    StringBuilder stringBuilder=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        /**
         * 递归 */
        //转化成数组
        char[] target = digits.toCharArray();
        combinationStep(target,0);
        return result;
    }

    private void combinationStep(char[] target, int index) {
        //出口
        if(index==target.length){
            result.add(stringBuilder.toString());
            return;
        }
        char c=target[index];
        char[] letters = phone.get(c).toCharArray();
        for (int i = 0; i < letters.length; i++) {
            stringBuilder.append(letters[i]);
            combinationStep(target, index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations=new LetterCombinations();
        letterCombinations.letterCombinations("23");
    }
}
