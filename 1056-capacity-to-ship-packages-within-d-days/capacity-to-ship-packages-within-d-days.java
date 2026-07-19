class Solution {
    public boolean isPossible(int[] arr, int d, int mid){
        int curr = 1;
        int currW = mid;
        for(int i=0; i<arr.length; i++){
            if(currW>=arr[i]){
                currW-=arr[i];
            }else{
                currW = mid-arr[i];
                curr++;
            }
            if(curr>d) return false;
        }
        return curr<=d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE, max = 0;
        for(int i=0; i<weights.length; i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        while(min<=max){
            int mid = (min+max)/2;
            if(isPossible(weights, days, mid)) max = mid-1; 
            else min = mid+1;
        }
        return min;
    }
}