class Solution {
    public boolean search(int[] nums, int target) {
        // idetify the sorted half and then eliminate accordingly. just remedy the condition when arr[beginning] == arr[middle] == arr[ending]
        int n = nums.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }
            // now to identify which half is sorted
            if(nums[low] <= nums[mid]){
                // this means that left half is sorted
                if(target>=nums[low] && target<=nums[mid]){
                    high = mid-1;
                }else low = mid+1;
            }else{
                if(target>=nums[mid+1] && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}