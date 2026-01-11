class Solution {
    public int findMin(int[] nums) {
        int minEl = Integer.MAX_VALUE;
        int n = nums.length;
        int low =0, high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                // left half is sorted.
                minEl = Math.min(minEl, nums[low]);
                low = mid+1;
            }else{
                minEl = Math.min(minEl, nums[mid]);
                high = mid-1;
            }
        }
        return minEl;
    }
}