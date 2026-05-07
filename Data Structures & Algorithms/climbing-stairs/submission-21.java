class Solution {
    public int climbStairs(int n) {
        // if (n <= 2) {
        //     return n;
        // }

        int[] stairs = new int[] {1, 2};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (var stair : stairs) {
                var remain = i - stair;
                if (remain >= 0) {
                    dp[i] = dp[i] + dp[remain];
                }
            }
        }

        return dp[n];
    }
}
