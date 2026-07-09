class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int el = nums[0];
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == el) cnt++;
            else{
                cnt--;
            }
            if(cnt == 0){
                el = nums[i];
                cnt = 1;
            }
        }
        return el;
    }
}