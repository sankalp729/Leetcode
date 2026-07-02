class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int i=0; i<=amount; i++){
            if(i % coins[0] == 0) dp[i] = i/coins[0];
            else dp[i] = (int)(1e9);
        }
        for(int i=1; i<n; i++){
            int[] curr = new int[amount+1];
            for(int j=0; j<=amount; j++){
                int notTake = 0 + dp[j];
                int take = (int)(1e9);
                if(j>=coins[i]) take = 1 + curr[j-coins[i]];
                curr[j] = Math.min(notTake, take);
            }
            dp = curr;
        }
        if(dp[amount] >= (int)(1e9)) return -1;
        else return dp[amount];
    }
}