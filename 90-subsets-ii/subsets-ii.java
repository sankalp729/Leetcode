class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int idx){
        ans.add(new ArrayList<>(temp));
        for(int i = idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            backtrack(ans, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}