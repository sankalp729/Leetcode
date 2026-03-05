class Solution {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int mid = 0, high = n-1, low = 0;
        while(mid<=high){
            if(nums[mid] == 0){
                swap(mid, low, nums);
                mid++;
                low++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(mid, high, nums);
                high--;
            }
        }
    }
}