class Solution {
    public int rec(int[] prices, int idx, int n, int buy, int[][] dp){
        if(idx == n) return 0;
        int profit = 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 0){
            profit = Math.max(-prices[idx] + rec(prices, idx+1, n, 1, dp), 0+ rec(prices, idx+1, n, 0, dp));
        }else{
            profit = Math.max(prices[idx] + rec(prices, idx+1, n, 0, dp), 0+ rec(prices, idx+1, n, 1, dp));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(prices, 0, n, 0, dp);
    }
}