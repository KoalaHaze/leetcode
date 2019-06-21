package stack;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if (!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else
                stack.push(c);
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        new RemoveDuplicates().removeDuplicates(s);
    }
}
