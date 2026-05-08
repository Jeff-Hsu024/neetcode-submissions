class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var costsum = 0;
        for (var c: cost) {
            costsum += c;
        }

        var len = cost.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, costsum + 1);
        dp[0] = 0;
        dp[1] = 0;

        int[] stairs = new int[] {1, 2};

        for (int i = 2; i < dp.length; i++) {
            var reach = i;
            for (var stair : stairs) {
                var pre = reach - stair;
                if (pre >= 0) {
                  var curCost = dp[pre] + cost[pre];
                  dp[i] = Math.min(dp[i], curCost);
                }
            }
        }

        return dp[len];
    }
}
