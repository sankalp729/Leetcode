class Solution {
    public int func(int[] nums, int k){
        int sub =0, subSum = 0;
        for(int i =0; i<nums.length; i++){
            if(subSum + nums[i] <=k){
                subSum += nums[i];
            }else{
                subSum = nums[i];
                sub++;
            }
        }
        return sub;
    }
    public int splitArray(int[] nums, int k) {
        // same as allocate books.
        if(k>nums.length) return -1;
        int sum = 0, max = -1;
        for(int i =0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            sum+= nums[i];
        }
        int start = max, end = sum;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(func(nums, mid) >= k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;  
    }
}