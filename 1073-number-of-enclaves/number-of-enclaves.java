class Solution {
    public void dfs(int[][] grid, int row, int col){
        grid[row][col] = 0;
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol] == 1){
                dfs(grid, nrow, ncol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i == 0 || i==n-1 || j==0 || j==m-1) && grid[i][j] == 1){
                    dfs(grid, i, j);
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}