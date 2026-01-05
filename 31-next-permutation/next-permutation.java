class Solution {
    public void nextPermutation(int[] nums) {
        int bIdx = -1;
        for(int i =0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1]) bIdx = i;
        }
        if(bIdx == -1){
            rev(nums, 0, nums.length-1);
            return;
        }
        for(int i = nums.length - 1; i>=0; i--){
            if(nums[i] > nums[bIdx]){
                swap(nums, i, bIdx);
                break;
            }
        }
        rev(nums, bIdx+1, nums.length - 1);
        return;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rev(int[] nums, int start, int end){
        for(int i = start, j = end; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}