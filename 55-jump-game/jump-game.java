class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(i>maxIdx) return false;
            maxIdx = Math.max(i+nums[i], maxIdx);
        }
        return maxIdx>= n-1;
    }
}