package medium.Top;

import java.util.Stack;

/*
* 394. 字符串解码
* */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null)
            return "";

        Stack<String> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) != ']'){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                String str = "";
                while (!stack.peek().equals("[")){
                    str += stack.pop();
                }
                stack.pop();

                String count = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0'
                        && stack.peek().charAt(0) <= '9'){
                    count = stack.pop() + count;
                }

                StringBuilder tmp = new StringBuilder();
                for (int j=0;j<Integer.parseInt(count);j++){
                    tmp.append(str);
                }
                stack.push(tmp.toString());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("30[a]2[bc]");
    }
}
