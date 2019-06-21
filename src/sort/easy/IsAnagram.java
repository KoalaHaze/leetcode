package sort.easy;

/*
* 242. 有效的字母异位词
* */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        int len = s.length();
        if (len != t.length())
            return false;
        int[] hash = new int[26];
        for (int i=0;i<len;i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for (int i=0;i<hash.length;i++){
            if (hash[i] != 0)
                return false;
        }

        return true;

    }
}
