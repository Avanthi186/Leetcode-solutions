class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for(int i = 1; i < n;i++){
            int pbuy = buy;
            int psell = sell;
            int pcooldown = cooldown;

            buy = Math.max(pbuy, pcooldown - prices[i]);
            sell = pbuy + prices[i];
            cooldown = Math.max(pcooldown, psell);
        }
        return Math.max(sell, cooldown);
    }
}