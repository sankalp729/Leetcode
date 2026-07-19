class Solution {
    public boolean isPossible(int[] nums, int t, int mid){
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            cnt+= (nums[i]+mid-1)/mid;
            if(cnt>t) return false;
        }
        return cnt<=t;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;
        for(int num : nums){
            high = Math.max(high, num);
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums, threshold, mid)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}