package medium.Top;

import medium.ListNode;


/*
*
19. 删除链表的倒数第N个节点
* */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*ListNode result = new ListNode(0);
        result.next = head;
        int len = 0;
        ListNode tmp = head;
        while (tmp != null){
            len++;
            tmp = tmp.next;
        }
        int del = len - n + 1;

        tmp = result;
        while (del > 1) {
            del--;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return result.next;*/

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode first = result;
        ListNode second = result;
        for (int i=0;i<n;i++){
            first = first.next;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return result.next;
}

}
