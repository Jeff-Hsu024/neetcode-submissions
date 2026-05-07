class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // from 1 coin to collect to amount coins
        for (int i = 1; i < dp.length; i++) {
            var currentWantCoins = i;
            for (var coin : coins) {
                // use coin to collect to currentWantCoins, still remain need collect.
                // like currentWantCoins: 95, use coin 2, still have 93 to collect.
                // but 93 result  was already calc, because this from bottom to up.
                // 93 was dp index, so remain need to be >= 0.
                var remain = currentWantCoins - coin;
                if (remain >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[remain]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
