package jzoffer;

import medium.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
* 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
* */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = listNode;
        while (tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
