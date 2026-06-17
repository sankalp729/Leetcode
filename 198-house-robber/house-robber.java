class Solution {
    public int rec(int[] nums, int[] dp, int idx){
        if(idx<0) return 0;
        if(idx == 0) return nums[0];
        if(dp[idx] == -1){
            int rob = nums[idx] + rec(nums, dp, idx-2);
            int notRob = rec(nums, dp, idx-1);

            return dp[idx] = Math.max(rob, notRob);
        }else{
            return dp[idx];
        }
    }
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rec(nums, dp, n-1);
    }
}