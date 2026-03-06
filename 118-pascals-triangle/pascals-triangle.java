class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(rows(i));
        }
        return ans;
    }
    public List<Integer> rows(int n){
        List<Integer> row = new ArrayList<>();
        int ans = 1;
        row.add(ans);
        for(int i=1; i<n; i++){
            ans = ans*(n-i);
            ans = ans/(i);
            row.add(ans);
        }
        return row;
    }
}