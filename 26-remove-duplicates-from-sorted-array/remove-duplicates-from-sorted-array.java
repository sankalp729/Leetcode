class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        int cnt=0;
        while(j<n){
            if(nums[i] == nums[j]) j++;
            else{
                nums[i+1] = nums[j];
                i++;
                cnt++;
            }
        }
        return cnt+1;
    }
}