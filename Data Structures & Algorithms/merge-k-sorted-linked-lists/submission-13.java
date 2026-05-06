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
            var top = pq.poll();
            tail.next = top;
            tail = tail.next;

            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }
}
