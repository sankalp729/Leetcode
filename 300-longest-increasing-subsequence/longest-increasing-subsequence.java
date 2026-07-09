class Solution {
    public int rec(int[] nums, int prev, int idx, int n, int[][] dp){
        if(idx > n) return 0;

        if(dp[idx][prev] != -1) return dp[idx][prev];
        int notTake = rec(nums, prev, idx+1, n, dp);
        
        int take = 0;
        if(prev ==0 || nums[prev-1] < nums[idx-1]) take = 1 + rec(nums, idx, idx+1, n, dp);

        return dp[idx][prev] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(nums, 0, 1, n, dp);
    }
}