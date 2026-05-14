class Solution {
    public void dfs(char[][] board, boolean[][] vis, int row, int col){
        vis[row][col] = true;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(board, vis, nrow, ncol);
            } 
        }
    }
    public void solve(char[][] board) {
        int n= board.length, m= board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i == 0 || i== n-1 || j == 0 || j==m-1) && board[i][j] == 'O' && !vis[i][j]) dfs(board, vis, i, j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}