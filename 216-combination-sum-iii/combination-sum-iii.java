class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] choices = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(ans, new ArrayList<>(), choices, k, n, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] arr, int k, int n, int idx){
        if(idx == arr.length || k==0){
            if(n == 0){
                if(k==0) ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(arr[i] > n) break;
            
            temp.add(arr[i]);
            backtrack(ans, temp, arr, k-1, n-arr[i], i+1);
            temp.remove(temp.size() - 1);
        }
    }
}