class Solution {
    public int rob(int[] nums) {
        var totalHouses = nums.length;
        if (totalHouses == 1) {
            return nums[0];
        }
        int withoutLast = helper(Arrays.copyOfRange(nums, 0, totalHouses - 1));
        int withLast = helper(Arrays.copyOfRange(nums, 1, totalHouses));

        return Math.max(withoutLast, withLast);
    }

    int helper(int[] nums) {
        var totalHouses = nums.length;

        if (totalHouses == 1) {
            return nums[0];
        }

        int[] dp = new int[totalHouses + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            var pre1 = dp[i - 1];
            var pre2 = dp[i - 2];
            var canrob = nums[i - 1];
            dp[i] = Math.max(pre1 + 0, pre2 + canrob);
        }
        return dp[totalHouses];
    }
}
