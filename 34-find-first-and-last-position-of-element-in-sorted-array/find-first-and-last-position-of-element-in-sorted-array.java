class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int low =0, high = nums.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                while(mid-1>=0 && nums[mid] == nums[mid-1]){
                    mid--;
                }
                ans[0] = mid;
                while(mid+1 < nums.length && nums[mid] == nums[mid+1]){
                    mid++;
                }
                ans[1] = mid;
                break;
            }
        }
        return ans;
    }
}