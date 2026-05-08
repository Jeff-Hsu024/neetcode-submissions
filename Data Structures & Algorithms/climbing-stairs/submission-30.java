class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[] {1, 2};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            var reach = i;
            for (var stair : stairs) {
                var pre = reach - stair;
                if (pre >= 0) {
                    // sum reach ways so need plus on before += result
                    dp[reach] = dp[reach] + dp[pre];
                }
            }
        }

        return dp[n];
    }
}
