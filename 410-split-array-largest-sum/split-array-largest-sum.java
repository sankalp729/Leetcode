class Solution {
    public int isPossible(int[] nums, int k, int mid){
        int students = 1, pages = mid;
        for(int i=0; i<nums.length; i++){
            if(pages>=nums[i]) pages-= nums[i];
            else{
                students++;
                pages = mid-nums[i];
            }
        }
        return students;
    }
    public int splitArray(int[] nums, int k) {
        if(k>nums.length) return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for(int i : nums){
            low = Math.max(low, i);
            high+= i;
        }
        while(low<=high){
            int mid = (low + high)/2;
            if(isPossible(nums, k, mid) <= k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}