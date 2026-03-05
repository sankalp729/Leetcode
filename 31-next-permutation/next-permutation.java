class Solution {
    public void reverse(int[] nums, int start, int end){
        for(int i= start, j= end; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int bpn = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                bpn = i;
                break;
            }
        }
        if(bpn == -1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i=n-1; i>=bpn; i--){
            if(nums[i] > nums[bpn]){
                int temp = nums[i];
                nums[i] = nums[bpn];
                nums[bpn] = temp;
                break;
            }
        }
        reverse(nums, bpn+1, n-1);
        return;
    }
}