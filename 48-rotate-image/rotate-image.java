class Solution {
    public void rev(int[] arr){
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length, m=matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i=0; i<n; i++){
            rev(matrix[i]);
        }
    }
}