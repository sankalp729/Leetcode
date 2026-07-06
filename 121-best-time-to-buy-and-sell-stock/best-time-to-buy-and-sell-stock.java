class Solution {
    public int maxProfit(int[] prices) {
        int minPurchase = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i=0; i<n; i++){
            if(prices[i] < minPurchase) minPurchase = prices[i];
            maxProfit = Math.max(maxProfit, prices[i]-minPurchase);
        }
        return maxProfit;
    }
}