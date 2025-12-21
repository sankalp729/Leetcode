class Solution {
    public int candy(int[] ratings) {
        int i = 1;
        int n = ratings.length;
        int sum = 1;
        while(i<n){
            if(i<n && ratings[i] == ratings[i-1]){
                sum++;
                i++;
            }
            int peak = 1;
            while(i<n && ratings[i] > ratings[i-1]){
                peak++;
                sum+= peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i] < ratings[i-1]){
                sum+= down;
                down++;
                i++;
            }
            if(down > peak) sum+= down - peak;
        }
        return sum;
    }
}