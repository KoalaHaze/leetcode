package hot100;

/*
* 10. 正则表达式匹配
* */
public class IsMatch {
    /*public boolean isMatch(String s, String p) {
        return backTrack(0,s,0,p);
    }

    public boolean backTrack(int i,String text,int j,String pattern){

        boolean result;
        if (j == pattern.length())
            result = i == text.length();
        else {
            boolean firstMatch = i<text.length() &&
                    (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

            if (j+1 < pattern.length() && pattern.charAt(j+1) == '*')
                result = backTrack(i,text,j+2,pattern) ||
                        (firstMatch && backTrack(i+1,text,j,pattern) );
            else
                result = firstMatch && backTrack(i+1,text,j+1,pattern) ;

        }
        return result;

    }*/

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 2; i <= p.length(); ++i) {
            if (p.charAt(i-1) == '*' && match[0][i - 2]) {
                match[0][i] = true;
            }
        }
        for (int i = 0; i <= s.length()-1; i++) {
            for (int j = 0; j <= p.length()-1; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    match[i+1][j+1] = match[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        match[i+1][j+1] = match[i][j+1] || match[i+1][j-1];
                    } else {
                        match[i][j] = match[i+1][j-1];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
