class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n=matrix.length, m=matrix[0].length;
        int left =0, right = m-1, up = 0, down = n-1;
        while(left<=right && up<=down){
            for(int i=left; i<=right; i++){
                list.add(matrix[up][i]);        
            }
            up++;
            for(int i=up; i<=down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(up<=down){
                for(int i=right; i>=left; i--){
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if(left<=right){
                for(int i=down; i>=up; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}