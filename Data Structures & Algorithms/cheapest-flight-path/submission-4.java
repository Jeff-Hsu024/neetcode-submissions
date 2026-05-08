class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int costsum = 0;
        for (int i = 0; i < flights.length; i++) {
            var cost = flights[i][2];
            costsum = costsum + cost;
        }

        int[] dp = new int[n];
        // src to dp[i] cost.
        // src to src cost 0.
        Arrays.fill(dp, costsum + 1);
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] nextDp = Arrays.copyOf(dp, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if (dp[from] != costsum + 1) {
                    nextDp[to] = Math.min(nextDp[to], dp[from] + cost);
                }
            }
            dp = nextDp;
        }

        return dp[dst] >= costsum + 1 ? -1 : dp[dst];
    }
}
