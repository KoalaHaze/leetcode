package hard;

/*
* 8. 字符串转换整数 (atoi)
* */
public class MyAtoi {
    public int myAtoi(String str) {

        int i=-1,j=str.length();         //双指针
        boolean isNagative = false;     //是否为负数
        for (int k=0;k<str.length();k++){
            if (str.charAt(k) != ' ' && i == -1){
                if (str.charAt(k) == '-' || str.charAt(k) == '+'){
                    isNagative = str.charAt(k) == '-';
                    if (k < str.length()-1 && str.charAt(k+1) <= '9' && str.charAt(k+1) >= '0'){
                        i = k+1;
                        continue;
                    }else
                        return 0;
                }
                else if (str.charAt(k) <= '9' && str.charAt(k) >= '0')
                    i = k;
                else
                    return 0;
            }
            if ((str.charAt(k) > '9' || str.charAt(k) < '0') && i != -1 ) {
                j = k;
                break;
            }
        }
        if (i == -1)
            return 0;

        String tmp = str.substring(i,j);
        int result = 0;
        for (int start=0;start<tmp.length();start++){
            int temp = tmp.charAt(start) - '0';
            if (!isNagative){
                if (result > Integer.MAX_VALUE/10 ||
                        (result == Integer.MAX_VALUE/10 && temp > 7))
                    return Integer.MAX_VALUE;
                result = result*10 + temp;
            }
            else{
                if (result < Integer.MIN_VALUE/10 ||
                        (result == Integer.MIN_VALUE/10 && temp > 8))
                    return Integer.MIN_VALUE;
                result = result*10 - temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new MyAtoi().myAtoi("  -0012a42");

    }
}
