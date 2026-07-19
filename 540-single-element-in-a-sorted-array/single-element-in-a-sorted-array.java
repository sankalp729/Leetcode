class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, n = nums.length;
        int high = n-1;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        while(low<=high){
            int mid = (low+high)/2;
            if(mid>0 && mid<n-1 && nums[mid] !=nums[mid-1] && nums[mid] !=nums[mid+1]) return nums[mid];
            else if((mid<n-1 && mid%2 ==0 && nums[mid] == nums[mid+1] ) || (mid>0 && mid%2 != 0 && nums[mid] == nums[mid-1])) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}