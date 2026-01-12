class Solution {
    public boolean isPossible(int[] piles, int h, int mid){
        int cnt = 0;
        for(int i =0; i<piles.length; i++){
            cnt+= Math.ceil((double)piles[i]/mid);
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i : piles) high = Math.max(high, i);
        while(low<=high){
            int mid = (low + high)/2;
            if(isPossible(piles, h, mid)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}