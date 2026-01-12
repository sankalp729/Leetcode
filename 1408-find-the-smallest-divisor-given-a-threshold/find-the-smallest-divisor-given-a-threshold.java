class Solution {
    public int isPossible(int[] nums, int threshold, int mid){
        int sum = 0;
        for(int i : nums){
            sum+= Math.ceil((double)i/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for(int i : nums) high = Math.max(high, i);
        while(low<=high){
            int mid = (low + high)/2;
            if(isPossible(nums, threshold, mid) <= threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}