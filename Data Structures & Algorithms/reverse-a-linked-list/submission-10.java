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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        var tail = head;
        while (tail != null) {
            var tmp = tail.next;

            tail.next = pre;
            pre=tail;

            tail = tmp;
        }

        return pre;
    }
}
