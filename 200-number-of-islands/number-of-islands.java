class Solution {
    public void dfs(char[][] grid, int i, int j){
        int n= grid.length, m= grid[0].length;
        grid[i][j] = '0';
        int[] delrow= {-1, 0, 1, 0};
        int[] delcol= {0, 1, 0, -1};
        for(int k=0; k<4; k++){
            int nrow= i+delrow[k];
            int ncol= j+delcol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1'){
                dfs(grid, nrow, ncol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt= 0;
        int n= grid.length, m= grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
}