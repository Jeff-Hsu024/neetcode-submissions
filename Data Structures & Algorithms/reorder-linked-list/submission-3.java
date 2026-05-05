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
    public void reorderList(ListNode head) {
        // find mid node
        var fast = head.next;
        var slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var mid = slow;

        // define asc, desc sorted node with first and second
        var second = slow.next;
        slow.next = null;
        var first = head;

        // reverse second
        ListNode pre = null;
        while (null != second) {
            var tmp = second.next;

            second.next = pre;
            pre = second;
            second = tmp;
        }
        second = pre;

        // merge

        while (second != null) {
            var tmp1 = first.next;
            var tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }

    }
}
