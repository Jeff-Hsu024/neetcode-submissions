class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int mn = nums[m];
            if (mn == target) {
                return m;
            }

            var ln = nums[l];
            var rn = nums[r];

            if (mn > rn) {
                // left sorted
                if (target >= ln && target < mn) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // right sorted
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
