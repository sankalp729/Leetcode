class Solution {
    public void rev(int[] nums, int start, int end){
        for(int i=start, j=end; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        int bpi = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                bpi = i;
                break;
            }
        }
        if(bpi == -1){
            rev(nums, 0, n-1);
            return;
        }
        for(int i=n-1; i>=0; i--){
            if(nums[i]>nums[bpi]){
                swap(nums, i, bpi);
                break;
            }
        }
        rev(nums, bpi+1, n-1);
    }
}