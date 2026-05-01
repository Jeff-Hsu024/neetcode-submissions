class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int bpos = 0;
        int spos = 1;
        
        while (spos < prices.length) {
            var buy = prices[bpos];
            var sell = prices[spos];
            
            var profit = sell - buy;
            max = Math.max(profit, max);

            if (buy > sell) {
                bpos = spos;
            }

            spos = spos + 1;
        }

        return max;
    }
}
