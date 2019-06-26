package hot100;

import medium.ListNode;

import java.util.Stack;

/*
* 234. 回文链表
* */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        /*if (head == null)
            return true;
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
            count++;
        }
        for (int i=0;i<=count/2;i++){
            if (stack.peek() != head.val){
                return false;
            }
            head = head.next;
            stack.pop();
        }
        return true;*/

        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow;
        ListNode next = slow.next;
        while (next.next != null){
            ListNode tmp = next.next;
            next.next = tmp.next;
            tmp.next = cur.next;
            cur.next = tmp;
        }

        slow = slow.next;
        while (slow != null){
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;


    }
}
