class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] arr, int t, int idx){
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(i>idx && arr[i] == arr[i-1]) continue;

            if(t>=arr[i]){
                temp.add(arr[i]);
                backtrack(ans, temp, arr, t-arr[i], i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}