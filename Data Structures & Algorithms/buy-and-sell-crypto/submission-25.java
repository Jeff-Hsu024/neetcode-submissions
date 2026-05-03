class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int b = 0;
        for (int s = 1; s < prices.length; s++) {
            var sell = prices[s];
            var buy = prices[b];
            var profit = sell - buy;
            res = Math.max(res, profit);

            if (buy > sell) {
                b = s;
            }
        }


        return res;
    }
}
