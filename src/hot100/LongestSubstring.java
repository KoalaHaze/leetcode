package hot100;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        int res = 0,len = s.length();
        int i = 0,j = i;
        HashSet<Character> hashSet = new HashSet<>();
        while (i < len && j < len){
            if (hashSet.contains(s.charAt(j))) {

                hashSet.remove(s.charAt(i++));
            }

            hashSet.add(s.charAt(j++));
            res = Math.max(res, j-i);

        }

        return res;
    }

    public static void main(String[] args) {
        new LongestSubstring().lengthOfLongestSubstring("qrsvbspk");
    }
}
