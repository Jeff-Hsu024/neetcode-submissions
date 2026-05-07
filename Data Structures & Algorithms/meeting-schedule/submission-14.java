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
        Collections.sort(
            intervals,
            (a, b) -> a.start - b.start
        );
        // var sortedls = intervals.stream().sorted((a, b) -> a.start - b.start).toList();
        for (int i = 0; i< intervals.size() -1; i++) {
            var cur = intervals.get(i);
            var next = intervals.get(i+1);
            if (cur.end > next.start) {
                return false;
            }
        }

        return true;
    }
}
