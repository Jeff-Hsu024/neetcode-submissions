class Solution {
    public int rob(int[] nums) {
        var len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // memo rob houses max money
        // i: total houses.
        // dp[i]: money.
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            // only can not this one use pre1
            // or pre2 plus curren.
            var pre1 = dp[i - 1];
            var pre2 = dp[i - 2];
            // 4th house index:3
            var canrob = nums[i - 1];
            dp[i] = Math.max(pre1 + 0, pre2 + canrob);
        }

        return dp[len];
    }
}
