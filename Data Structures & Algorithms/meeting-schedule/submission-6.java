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
        List<Interval> sorted = intervals.stream().sorted((a, b) -> a.start - b.start).toList();
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i).end > sorted.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }
}
