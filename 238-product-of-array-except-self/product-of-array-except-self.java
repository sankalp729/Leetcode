class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] prod = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i = 1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[n-1-i] = suffix[n-i] * nums[n-i];
        }
        for(int i = 0; i<n; i++){
            prod[i] = prefix[i]*suffix[i];
        }
        return prod;
    }
}