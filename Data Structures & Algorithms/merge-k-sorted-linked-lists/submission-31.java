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
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (var n:lists) {
            if (null == n) {
                continue;
            }
            q.offer(n);
        }
        ListNode d = new ListNode();
        var tail = d;
        while (!q.isEmpty()) {
            var n = q.poll();
            tail.next = n;
            tail = tail.next;
            if (n.next != null) {
                q.offer(n.next);
            }
        }

        return d.next;
    }
}
