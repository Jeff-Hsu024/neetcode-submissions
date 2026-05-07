class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        // dp[2] = from dp[0] or from dp[1]
        // dp[1]: use cost[0] or cost[1], the min
        // dp[1] = cost[0] or cost[1], the min
        // dp[2] = cost[0] or cost[1], the min
        // dp[3] = can from dp[1] or dp[2] + the cost
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min((dp[i - 2] + cost[i - 2]), (dp[i - 1] + cost[i - 1]));
        }
        return dp[n];
    }
}
