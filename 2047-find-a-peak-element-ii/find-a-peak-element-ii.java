class Solution {
    public int maxEl(int[][] arr, int col){
        int max = -1, idx = -1;
        for(int i =0; i<arr.length; i++){
            if(arr[i][col] > max){
                max = arr[i][col];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m-1;
        int[] ans = {-1, -1};
        while(low<=high){
            int col = (low + high)/2;
            int row = maxEl(mat, col);
            int left = col-1>=0 ? mat[row][col-1] : -1;
            int right = col+1<m ? mat[row][col+1] : -1;
            if(mat[row][col] > left && mat[row][col] > right){
                ans[0] = row;
                ans[1] = col;
                return ans;
            }else if(mat[row][col] < left) high =col-1;
            else low = col+1;
        }
        return ans;
    }
}