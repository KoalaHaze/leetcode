package hot100;

/*
* 10. 正则表达式匹配
* */
public class IsMatch {
    public boolean isMatch(String s, String p) {
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

    }
}
