class Solution {
    public int rec(int i, int j, List<List<Integer>> triangle, int n, List<List<Integer>> dp){
        if(i == n-1) return triangle.get(i).get(j);

        if(dp.get(i).get(j) != null) return dp.get(i).get(j);

        int down = triangle.get(i).get(j) + rec(i+1, j, triangle, n, dp);
        int diag = triangle.get(i).get(j) + rec(i+1, j+1, triangle, n, dp);

        int ans = Math.min(down, diag);
        dp.get(i).set(j, ans);
        return ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                row.add(null);
            }
            dp.add(row);
        }
        return rec(0, 0 , triangle, n, dp);
    }
}