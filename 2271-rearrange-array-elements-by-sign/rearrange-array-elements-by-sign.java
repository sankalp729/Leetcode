class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int[] ans = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            if(nums[i] > 0) positive.add(nums[i]);
            else negative.add(nums[i]);
        }
        for(int i =0; i<positive.size(); i++){
            ans[2*i] = positive.get(i);
        }
        for(int i = 0; i<negative.size(); i++){
            ans[2*i + 1] = negative.get(i);
        }
        return ans;
    }
}