class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    public boolean backtrack(char[][] board){
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c ='1'; c<='9'; c++){
                        if(isSafe(board, i, j, c) == true){
                            board[i][j] = c;

                            if(backtrack(board) == true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board, int row, int col, char c){
        for(int i =0; i<9; i++){
            if(board[row][i] == c) return false;
            else if(board[i][col] == c) return false;
            else if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}