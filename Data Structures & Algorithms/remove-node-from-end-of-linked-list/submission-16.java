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
        ListNode dummy = new ListNode();
        dummy.next = head;

        var l = dummy;
        var r = head;
        while (n > 0 && r!= null) {
            r = r.next;
            n--;
        }

        while (r != null) {
            r = r.next;
            l = l.next;
        }

        l.next = l.next.next;


        return dummy.next;
    }
}
