class Solution {
    public int rec(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i == m-1 && j == n-1) return grid[m-1][n-1];
        if(i> m-1 || j> n-1) return (int)1e8;

        if(dp[i][j] != -1) return dp[i][j];

        int down = grid[i][j] + rec(i+1, j, m, n, grid, dp);
        int right = grid[i][j] + rec(i, j+1, m, n, grid, dp);

        return dp[i][j] = Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(0, 0, m, n, grid, dp);
    }
}