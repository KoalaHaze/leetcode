package string;

import java.util.HashMap;

/*
* 13. 罗马数字转整数
* */
public class RomanToInt {
    public int romanToInt(String s) {

        
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int result = 0;
        for (int i=s.length()-1;i>=0;i--){
            if (i>0 && hm.get(s.charAt(i)) > hm.get(s.charAt(i-1))){
                result += hm.get(s.charAt(i)) - hm.get(s.charAt(i-1));
                i--;
            }
            else
                result += hm.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "III";
        new RomanToInt().romanToInt(s);
    }
}
