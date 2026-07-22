class Solution {
    public boolean isPossible(int[] nums, int k, int mid){
        int cnt = 1;
        int curr = mid;
        for(int i=0; i<nums.length; i++){
            if(curr>=nums[i]) curr-=nums[i];
            else{
                curr = mid-nums[i];
                cnt++;
            }
            if(cnt>k) return false;
        }
        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0, n=nums.length;
        for(int i=0; i<n; i++){
            low = Math.max(low, nums[i]);
            high+= nums[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums, k, mid)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}