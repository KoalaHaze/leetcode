package hot100;

public class StringsMultiply {
//    public String multiply(String num1, String num2) {
//        int l1 = num1.length() , l2 = num2.length();
//        if ("0".equals(num1) || "0".equals(num2))
//            return "0";
//        String res = "0";
//        int mult = 0;
//        for (int i = l1-1;i>=0;i--){
//            StringBuilder str = new StringBuilder();
//            int n = i;
//            while (n < l1 - 1){
//                str.append(0);
//                n++;
//            }
//            int tmp = 0,mid = 0;
//            for (int j=l2-1;j >=0;j--){
//                int i1 = num1.charAt(i) - '0';
//                int i2 = num2.charAt(j) - '0';
//                tmp = (i1*i2 + mid ) % 10;
//                mid = (i1*i2 + mid ) / 10;
//                str.append(tmp);
//            }
//            if (mid > 0)
//                str.append(mid);
//            res = new StringsAdd().addStrings(res,str.reverse().toString());
//        }
//        return res;
//    }

    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        StringBuilder sb = new StringBuilder();

        int l1 = num1.length(),l2 = num2.length();
        int[] res = new int[l1+l2];
        for (int i=l1-1;i>=0;i--){
            int tmp = 0,mid = 0;
            int n1 = num1.charAt(i) - '0';
            for (int j=l2-1;j>=0;j--){
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + res[i + j + 1];
                tmp = sum % 10;
                mid = sum / 10;
                res[i+j+1] = tmp;
                res[i+j] += mid;
            }

        }
        for (int n = 0;n<res.length;n++){
            if (n == 0 && res[n] == 0)
                continue;
            else
                sb.append(res[n]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new StringsMultiply().multiply("123","456"));
        System.out.println(new StringsMultiply().multiply1("123","456"));
    }
}
