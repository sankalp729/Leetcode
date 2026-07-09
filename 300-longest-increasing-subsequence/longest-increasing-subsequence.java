class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+1];
        for(int idx = n; idx>=1; idx--){
            for(int prev = idx-1; prev>=0; prev--){
                int notTake = dp[idx+1][prev];

                int take = 0;
                if(prev == 0 || nums[idx-1] > nums[prev-1]){
                    take = 1+dp[idx+1][idx];
                }
                dp[idx][prev] = Math.max(take, notTake);
            }
        }
        return dp[1][0];
    }
}