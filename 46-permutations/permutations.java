class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), vis, nums, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, boolean[] vis, int[] nums, int idx){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0; i<nums.length; i++){
            if(!vis[i]){
                vis[i] = true;
                temp.add(nums[i]);
                backtrack(ans, temp, vis, nums, i+1);
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}