class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rev(nums, 0, nums.length -1);
        rev(nums, 0, k-1);
        rev(nums, k, nums.length-1);
    }
    public void rev(int[] nums, int start, int end){
        for(int i = start, j = end; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}