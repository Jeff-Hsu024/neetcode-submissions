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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode();
        var tail = dummy;

        var list1remain = list1;
        var list2remain = list2;

        while (null != list1remain && null != list2remain) {
            var l1Val = list1remain.val;
            var l2Val = list2remain.val;
            if (l1Val <= l2Val) {
                tail.next = new ListNode(l1Val);
                list1remain = list1remain.next;
            } else {
                tail.next = new ListNode(l2Val);
                list2remain = list2remain.next;
            }

            tail = tail.next;
        }

        if (list1remain != null) {
            tail.next = list1remain;
        }

        if (list2remain != null) {
            tail.next = list2remain;
        }

        return dummy.next;
    }
}