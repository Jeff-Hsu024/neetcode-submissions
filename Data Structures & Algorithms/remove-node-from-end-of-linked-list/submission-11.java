/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        // act left and right from head start, left will landing on we want deleted.
        // so need use dummy start from head previous.
        var left = dummy;
        var right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        // push right to end.
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        // left next that we want deleted, so shift to next next.
        left.next = left.next.next;

        return dummy.next;
    }
}
