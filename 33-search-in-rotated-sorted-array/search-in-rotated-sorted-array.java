class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low =0, high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                // this means that the left half is sorted.
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }else{
                // this means that the right half is sorted.
                if(nums[mid] <= target && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}