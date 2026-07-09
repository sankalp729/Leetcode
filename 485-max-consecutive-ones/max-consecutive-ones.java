class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, n = nums.length;
        int curr = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1) curr++;
            else curr = 0;
            max = Math.max(curr, max);
        }
        return max;
    }
}