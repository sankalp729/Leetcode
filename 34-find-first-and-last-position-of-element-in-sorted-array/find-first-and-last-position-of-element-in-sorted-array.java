class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int first = -1, second = -1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else high = mid-1;
        }
        low =0;
        high = nums.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                second = mid;
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else low = mid+1;
        }
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
}