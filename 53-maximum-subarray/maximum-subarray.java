class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE, ansStart = -1, ansEnd = -1, start = -1;
        for(int i =0; i<nums.length; i++){
            if(currSum == 0) start = i;
            currSum+= nums[i];
            if(currSum > maxSum){
                maxSum = currSum;
                ansStart = start;
                ansEnd = i;
            }
            if(currSum < 0) currSum = 0;
        }
        for(int i = ansStart; i<=ansEnd; i++){
            System.out.print(nums[i] + " ");
        }
        return maxSum;
    }
}