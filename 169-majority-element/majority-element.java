class Solution {
    public int majorityElement(int[] nums) {
        int el = nums[0];
        int cnt =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == el){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt == 0){
                cnt = 1;
                el = nums[i];
            }
        }
        return el;
    }
}