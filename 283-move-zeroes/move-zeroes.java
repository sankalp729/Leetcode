class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int n = nums.length;
        while(j<n && nums[j] != 0){
            j++;
        }
        if(j == n-1) return;
        int i = j+1;
        while(i<n){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            i++;
        }
    }
}