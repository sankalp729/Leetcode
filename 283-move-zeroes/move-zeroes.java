class Solution {
    public void moveZeroes(int[] nums) {
        // step 1 : determine the index of the first zero : 
        int i =0, j =0;
        for(int k =0; k<nums.length; k++){
            if(nums[k] == 0){
                j =k;
                i =k+1;
                break;
            }
        }
        while(i<nums.length){
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