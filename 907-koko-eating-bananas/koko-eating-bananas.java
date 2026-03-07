class Solution {
    public long isPossible(int[] piles, int h, int mid){
        long sum = 0;
        for(int i =0; i<piles.length; i++){
            sum+= (long)(piles[i] + mid - 1)/ mid;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for(int i: piles){
            high = Math.max(high, i);
        }
        while(low<=high){
            int mid = (low + high)/2;
            if(isPossible(piles, h, mid) > h) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}