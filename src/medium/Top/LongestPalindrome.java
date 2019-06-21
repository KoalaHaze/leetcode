package medium.Top;

/*
* 5. 最长回文子串
 * */
public class LongestPalindrome {
    public String longestPalindrome(String s) {

        if (s.length()<1)
            return "";
        int start = 0 , end = 0;
        for (int i=0;i<s.length();i++){
            int len1 = extendAroundCenter(s,i,i);
            int len2 = extendAroundCenter(s,i,i+1);
            int len  = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len-1) / 2;
                end = i + len/2 + 1;
            }
        }
        return s.substring(start,end);
    }

    public int extendAroundCenter(String s,int left,int right){
        int l = left , r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l -- ;
            r ++ ;
        }
        return r - l - 1;
    }

}
