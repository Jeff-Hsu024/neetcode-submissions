class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            var ln = nums[l];
            var rn = nums[r];
            if (ln <= rn) {
                return ln;
            }
            var m = l + (r - l) / 2;
            var mn = nums[m];
            if (mn > rn) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
