class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // might found at last same, need l equals r.
        while (l <= r) {
            var ln = nums[l];
            var rn = nums[r];

            int m = l + (r - l) / 2;
            var mn = nums[m];
            if (mn == target) {
                return m;
            }

            if (mn >= ln) {
                // left side sorted.
                if (target < mn && target >= ln) {
                    // at left side, reduce r.
                    r = m - 1;
                } else {
                    // otherwise, improve l.
                    l = m + 1;
                }

            } else {
                // right side sorted.
                if (target > mn && target <= rn) {
                    // at right side, improve l.
                    l = m + 1;
                } else {
                    // otherwise, reduce r.
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
