class Solution {
    public int rec(int[] coins, int target, int idx, int[][] dp){
        if(idx == 0){
            if(target%coins[idx] == 0){
                return target/coins[idx];
            }else{
                return (int)(1e9);
            }
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        int notTake = 0 + rec(coins, target, idx-1, dp);

        int take = (int)(1e9);
        
        if(target>= coins[idx]) take = 1 + rec(coins, target-coins[idx], idx, dp);

        return dp[idx][target] = Math.min(take, notTake); 
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = rec(coins, amount, n-1, dp);

        if(ans>=(int)(1e9)) return -1;
        else return ans;
    }
}