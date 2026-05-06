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
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mls = new ArrayList<>();
            for (int i = 0; i < lists.length; i = i + 2) {
                var l1 = lists[i];
                var l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mls.add(merge(l1, l2));
            }
            lists = mls.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        var tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
