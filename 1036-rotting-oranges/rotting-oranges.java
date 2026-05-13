class Pair{
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int cntFresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.offer(new Pair(i, j, 0));
                }

                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int cnt = 0;
        int time = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int tm = p.tm;

            time = Math.max(time, tm);

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    cnt++;
                    q.offer(new Pair(nrow, ncol, tm+1));
                }
            }
        }
        if(cnt != cntFresh) return -1;
        else return time;
    }
}