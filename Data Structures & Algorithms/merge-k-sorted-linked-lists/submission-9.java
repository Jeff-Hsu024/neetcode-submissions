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
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (var node : lists) {
            if (null == node) {
                continue;
            }
            pq.add(node);
        }
        ListNode dummy = new ListNode();
        var tail = dummy;
        while (!pq.isEmpty()) {
            var min = pq.poll();
            tail.next = min;
            tail = tail.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
