package medium.greedy;

/*
* 402. 移掉K位数字
* */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {

        if (num == null || k>=num.length())
            return "0";
        StringBuilder sb = new StringBuilder(num);

        while (k > 0){
            int idx = 0;
            for (int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++)
                idx = j;
            sb.delete(idx, idx + 1);
            k--;

        }
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.delete(0,1);
        }
        if (sb.length() <= 0)
            return "0";

        return sb.toString();
    }
}
