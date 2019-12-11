package hot100;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<len;i++) {
            char ch = s.charAt(i);
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.add(ch);
            }
            else {
                if (stack.empty())
                    return false;
                else {
                    if (')' == ch) {
                        if (stack.peek() == '(')
                            stack.pop();
                        else
                            return false;
                    } else if (']' == ch) {
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            return false;
                    } else if ('}' == ch) {
                        if (stack.peek() == '{')
                            stack.pop();
                        else
                            return false;
                    }

                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("([)]"));
    }
}
