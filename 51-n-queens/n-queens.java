class Solution {
    public boolean isSafe(int row, int col, int n, char[][] board){
        int origRow = row, origCol = col;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row= origRow;
        col= origCol;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row= origRow;
        col= origCol;
        while(col>=0 && row<n){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list= new ArrayList<>();
        List<String> temp= new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        rec(list, temp, n, 0, board);
        return list;
    }
    public void rec(List<List<String>> list, List<String> temp, int n, int col, char[][] board){
        if(col == n){
            list.add(construct(board));
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(row, col, n, board)){
                board[row][col] = 'Q';
                rec(list, temp, n, col+1, board);
                board[row][col] = '.';
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> temp= new ArrayList<>();
        for(int i=0; i<board.length; i++){
            temp.add(new String(board[i]));
        }
        return temp;
    }
}