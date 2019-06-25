package medium.Top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 17. 电话号码的字母组合
* */
public class LetterCombinations {
     Map<Integer,String> map = new HashMap<>();
     List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        if (digits.length() >= 1)
            backTrack("",digits);
        return list;
    }

    public void backTrack(String cur,String next){
        if (next.length() == 0)
            list.add(cur);
        else {
            int nextNum = Integer.parseInt(next.substring(0,1));
            String phones = map.get(nextNum);
            for (int i=0;i<phones.length();i++){
                String phone = phones.substring(i,i+1);
                backTrack(cur+phone,next.substring(1));
            }
        }

    }
}
