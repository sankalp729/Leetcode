class Solution {
    public int findMin(int[] nums) {
        // identify the sorted half and replace its first element with the minEl.
        int n = nums.length;
        int minEl = Integer.MAX_VALUE;
        int low =0, high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
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