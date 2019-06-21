package stack;

import java.util.Stack;

public class Effective_parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty())
                    return false;


                else {
                    char p = stack.pop();
                    if (c == ')' &&  p != '(')
                        return false;
                    else if (c == ']' && p != '[')
                        return false;
                    else if (c == '}' && p != '{')
                        return false;
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
