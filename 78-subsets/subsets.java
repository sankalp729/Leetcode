class Solution {
    public void rec(int[] nums, int idx, List<Integer> temp, List<List<Integer>> ans, int n){
        if(idx >= n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // take :
        temp.add(nums[idx]);
        rec(nums, idx+1, temp, ans, n);
        temp.remove(temp.size() - 1);

        // notTake : 
        rec(nums, idx+1, temp, ans, n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(nums, 0, temp, ans, n);
        return ans;
    }
}