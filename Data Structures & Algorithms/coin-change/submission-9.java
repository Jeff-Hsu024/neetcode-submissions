class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int currentAmount = 0; currentAmount < dp.length; currentAmount++) {
            for (var coin : coins) {
                var remain = currentAmount - coin;
                if (remain >= 0) {
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[remain]);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }
}
