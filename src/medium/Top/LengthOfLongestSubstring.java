package medium.Top;

import java.util.HashMap;

/*
* 3. 无重复字符的最长子串
* */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

            HashMap<Character,Integer> hm = new HashMap<>();
            int max = 0;
            int count = 0;
            for (int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if (hm.containsKey(c)) {
                    count = Math.max(hm.get(c),count);
                }
                max = Math.max(max,i-count+1);
                hm.put(c,i+1);
            }
            return max;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf");
    }
}
