/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        var sortedls = intervals.stream().sorted((a, b) -> a.start - b.start).toList();
        for (int i = 0; i< sortedls.size() -1; i++) {
            var cur = sortedls.get(i);
            var next = sortedls.get(i+1);
            if (cur.end > next.start) {
                return false;
            }
        }

        return true;
    }
}
