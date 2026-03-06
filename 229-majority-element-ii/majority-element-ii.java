class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // so this is majority element 2!
        List<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != el2 && cnt1 == 0){
                el1 = nums[i];
                cnt1 = 1;
            }else if(nums[i] != el1 && cnt2 == 0){
                el2 = nums[i];
                cnt2 = 1;
            }else if(nums[i] == el1) cnt1++;
            else if(nums[i] == el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == el1) cnt1++;
            if(nums[i] == el2) cnt2++;
        }
        if(cnt1>=(nums.length/3) + 1) ans.add(el1);
        if(cnt2>=(nums.length/3) + 1) ans.add(el2);
        return ans;
    }
}