class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i =0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        boolean[] leftRow = new boolean[n];
        boolean[] diag1 = new boolean[2*n - 1];
        boolean[] diag2 = new boolean[2*n - 1];

        backtrack(res, leftRow, diag1, diag2, board, n, 0);

        return res;
    }
    public void backtrack(List<List<String>> res, boolean[] leftRow, boolean[] diag1, boolean[] diag2, char[][] board, int n, int col){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(char[] ch : board){
                temp.add(new String(ch));
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int row =0; row < n; row++){
            if(leftRow[row] || diag1[row + col] || diag2[row - col + n - 1]) continue;

            leftRow[row] = diag1[row+col] = diag2[row-col+n-1] = true;
            board[row][col] = 'Q';

            backtrack(res, leftRow, diag1, diag2, board, n, col+1);

            leftRow[row] = diag1[row+col] = diag2[row-col+n-1] = false;
            board[row][col] = '.';
        }
    }
}