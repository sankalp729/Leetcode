class Solution {
    public boolean isPossible(int[] piles, int h, int mid){
        int sum = 0;
        for(int i=0; i<piles.length; i++){
            sum+= (piles[i] + mid-1)/mid;
            if(sum>h) return false;
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            high = Math.max(high, piles[i]);
        } 
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(piles, h, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}