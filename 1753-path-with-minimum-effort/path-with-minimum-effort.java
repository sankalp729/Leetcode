class Pair{
    int diff;
    int row;
    int col;
    Pair(int diff, int row, int col){
        this.diff= diff;
        this.row= row;
        this.col= col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length, m= heights[0].length;
        PriorityQueue<Pair> pq= new PriorityQueue<>((x, y) -> (x.diff- y.diff));
        int[][] dist= new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        int[] delrow= {-1, 0, 1, 0};
        int[] delcol= {0, 1, 0, -1};
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int diff= p.diff;
            int row= p.row;
            int col= p.col;
            if(row == n-1 && col == m-1) return diff;
            for(int i=0; i<4; i++){
                int nrow= row+delrow[i];
                int ncol= col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort= Math.max(diff, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if(dist[nrow][ncol] > newEffort){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Pair(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}