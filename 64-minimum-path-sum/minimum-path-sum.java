class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i ==0 && j == 0){
                    temp[j] = grid[0][0];
                    continue;
                }
                int up =(int)1e8, left = (int)1e8;
                if(i>0) up = grid[i][j] + prev[j];
                if(j>0) left = grid[i][j] + temp[j-1];
                temp[j] = Math.min(up, left);
            }
            prev = temp;
        }
        return prev[n-1];
    }
}