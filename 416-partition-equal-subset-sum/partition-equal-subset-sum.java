class Solution {
    public boolean subSum(int[] nums, int target, int idx, int[][] dp, int n){
        if(target == 0) return true;
        if(idx == n) return false;

        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean take = false;
        if(target>=nums[idx]) take = subSum(nums, target-nums[idx], idx+1, dp, n);
        boolean notTake = subSum(nums, target, idx+1, dp, n);

        if(take || notTake) dp[idx][target] = 1;
        else dp[idx][target] = 0;

        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum+= nums[i];
        }
        if(sum%2 != 0) return false;
        else{
            int[][] dp = new int[n][sum/2 + 1];
            for(int[] row : dp){
                Arrays.fill(row, -1);
            }
            return subSum(nums, sum/2, 1, dp, n);
        }
    }
}