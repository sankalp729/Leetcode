class Solution {
    public int rec(int i, int j, int[][] grid, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i>m-1 || j>n-1) return 0;

        if(grid[i][j] != 1){
            if(dp[i][j] != -1) return dp[i][j];

            int down = rec(i+1, j, grid, m, n, dp);
            int right = rec(i, j+1, grid, m, n, dp);
            return dp[i][j] = down+right;

        }else return 0; 
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(0, 0, obstacleGrid, m, n, dp);
    }
}