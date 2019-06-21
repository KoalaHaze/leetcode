package medium.Top;

import medium.ListNode;

/*
* 2. 两数相加
* */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode p = l1 , q = l2;
        int carr = 0;   //进位
        while (p != null || q != null){
            int pa = p == null ? 0:p.val;
            int qa = q == null ? 0:q.val;
            int sum = pa + qa + carr;
            carr = sum / 10;
            temp.next = new ListNode(sum%10);
            p = p == null ? p:p.next;
            q = q == null ? q:q.next;
            temp = temp.next;
        }
        if (carr == 1)
            temp.next = new ListNode(carr);
        return result.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2); l1.next = new ListNode(4); l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5); l2.next = new ListNode(6); l2.next = new ListNode(8);
        new AddTwoNumbers().addTwoNumbers(l1,l2);
    }
}
