class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int b = 0;

        for (int s = 0; s < prices.length; s++) {
            var buy = prices[b];
            var sell = prices[s];
            var profit = sell - buy;
            res = Math.max(res, profit);

            if (buy > sell) {
                b = s;
            }
        }

        return res;
    }
}
