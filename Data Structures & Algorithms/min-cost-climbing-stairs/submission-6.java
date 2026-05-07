class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            var pre1cost = dp[i - 1] + cost[i - 1];
            var pre2cost = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(pre1cost, pre2cost);
        }

        return dp[n];
    }
}
