package easy;

/*
* 709. 转换成小写字母
* */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) - 'A' < 26 && str.charAt(i) - 'A' >= 0)
                sb.append((char)(str.charAt(i)+32));
            else
                sb.append(str.charAt(i));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) ('A'+32));
        System.out.println('Z'-'A');
        System.out.println('a'-'A');
        System.out.println('z'-'A');
    }
}
