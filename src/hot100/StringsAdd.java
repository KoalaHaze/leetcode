package hot100;

public class StringsAdd {
    public String addStrings(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();
        int a = n1-1,b = n2-1;

        StringBuilder sb = new StringBuilder();

        int tmp = 0,mid = 0;
        int nm1 = 0,nm2 = 0;
        while (a >= 0 || b >= 0){
            if (a >= 0){
                nm1 = num1.charAt(a) - '0';
                a--;
            }else
                nm1 = 0;
            if (b >= 0){
                nm2 = num2.charAt(b) - '0';
                b--;
            }else
                nm2 = 0;

            tmp = (nm1 + nm2 + mid) % 10;
            mid = (nm1 + nm2 + mid) / 10;

            sb.append(tmp);

        }
        if(mid > 0)
            sb.append(mid);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = new StringsAdd().addStrings("123","456");
        System.out.println(res);
    }
}
