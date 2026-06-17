class Solution {
    public int rec(int n, int[] dp){
        if(n<0) return 0;
        if(n <=2) return n;
        
        if(dp[n] == -1){
            int one = rec(n-1, dp);
            int two = rec(n-2, dp);    
            return dp[n] = one+two;
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }
}