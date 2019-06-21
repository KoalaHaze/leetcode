package easy;

/*
* 557. 反转字符串中的单词 III
* */
public class ReverseWords {
    public String reverseWords(String s) {
        if(s == null || s == "")
            return "";
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int p = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                p = i-1;
                while (p >= l) {
                    sb.append(s.charAt(p));
                    p--;
                }
                sb.append(' ');
                l = i+1;
            }
        }
        p = s.length()-1;
        while (p >= l) {
            sb.append(s.charAt(p));
            p--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        new ReverseWords().reverseWords(s);
    }
}
