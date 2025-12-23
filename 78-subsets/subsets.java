class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int idx, int[] nums){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // choice 1 : do not include
        backtrack(ans, temp, idx+1, nums);
        // choice 2 : do include
        temp.add(nums[idx]);
        backtrack(ans, temp, idx+1, nums);

        // undo the choice means backtrack
        temp.remove(temp.size() - 1);
    }
}