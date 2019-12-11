package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    HashMap<Character,String> hm = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return res;

        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");


        String sb = new String();
        getLetter(digits,0,sb);

        return res;

    }

    public void getLetter(String digits,int num,String string){
        if (num < digits.length()){
            Character character = digits.charAt(num);
            String lett = hm.get(character);
            for (int i=0;i<lett.length();i++) {
                String s = String.valueOf(lett.charAt(i));
                getLetter(digits, num + 1, string+s);
            }
        }else
            res.add(string);

    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
