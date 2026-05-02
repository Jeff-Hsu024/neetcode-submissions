class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int b = 0;
        int s = 1;

        while (s < prices.length) {
            var buy = prices[b];
            var sell = prices[s];

            if (sell < buy) {
                b = s;
                s = b + 1;
            } else {
                var profit = sell - buy;
                res = Math.max(res, profit);
                s = s + 1;
            }
        }

        return res;
    }
}
