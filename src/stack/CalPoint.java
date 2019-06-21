package stack;

import java.util.Stack;

//棒球比赛
public class CalPoint {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int points = 0;
        for (String s:ops) {
            if (s.equals("+")){
               int p = stack.pop();
               int newp = p + stack.peek();
               stack.push(p);
               stack.push(newp);
               points += newp;
            }else if (s.equals("C")){
                points -= stack.peek();
                stack.pop();
            }else if (s.equals("D")){
                points += stack.peek()*2;
                stack.push(stack.peek()*2);
            }else {
                stack.push(Integer.parseInt(s));
                points += Integer.parseInt(s);
            }
        }
        System.out.println(points);
        return points;
    }

    public static void main(String[] args) {
        String[] ops = {"57","D","-3","-58","D","77","+","C","+","+","38","78","-6","24","-46","+","31","20","D","-81"};
        new CalPoint().calPoints(ops);
    }
}
