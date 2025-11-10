class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        for (int price : prices) {
            // First buy: find lowest price
            buy1 = Math.min(buy1, price);
            // First sell: maximize profit after first buy
            profit1 = Math.max(profit1, price - buy1);

            // Second buy: use profit1 to offset cost of buying again
            buy2 = Math.min(buy2, price - profit1);
            // Second sell: maximize total profit
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }
}
