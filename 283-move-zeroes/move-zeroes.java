class Solution {
    public void moveZeroes(int[] nums) {
        int i =0, j= 0;
        for(int k = 0; k<nums.length; k++){
            if(k<nums.length - 1 && nums[k] == 0){
                j = k;
                i = k+1;
                break;
            } 
        }
        while(i<nums.length){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
    }
}