class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

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
                    r = m - 1;
                } else {
                    l = m + 1;
                }

            } else {
                // right side sorted.
                if (target > mn && target <= rn) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
