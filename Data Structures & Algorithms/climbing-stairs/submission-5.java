class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        // 4 = (4-1) + (4-2);
        // 0 = 0
        // 1 = 1
        // 2 = 2
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
