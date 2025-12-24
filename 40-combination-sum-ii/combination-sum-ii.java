class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void backtrack(int[] arr, int t, List<List<Integer>> ans, List<Integer> temp, int idx){
        
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        } 
           
        for(int i = idx; i<arr.length; i++){
            if(i>idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > t) break;
            
            // choice 1 : adding
            temp.add(arr[i]);
            backtrack(arr, t-arr[i], ans, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}