class Pair{
    int node;
    int row;
    int col;
    Pair(int node, int row, int col){
        this.node= node;
        this.row= row;
        this.col= col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        PriorityQueue<Pair> pq= new PriorityQueue<>((x, y) -> (x.node- y.node));
        pq.add(new Pair(grid[0][0] ,0, 0));
        int[] drow= {-1, 0, 1, 0};
        int[] dcol= {0, 1, 0, -1};
        boolean[][] vis= new boolean[n][n];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node= p.node;
            int row= p.row;
            int col= p.col;
            if(row == n-1 && col == n-1) return node;
            for(int i=0; i<4; i++){
                int nrow= row+drow[i];
                int ncol= col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    pq.add(new Pair(Math.max(grid[nrow][ncol], node), nrow, ncol));
                }
            }
        }
        return -1;
    }
}