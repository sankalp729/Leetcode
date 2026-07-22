class Solution {
    public boolean isPossible(int[] arr, int days, int mid){
        int cnt = 1, curr=mid;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=curr) curr-= arr[i];
            else{
                curr = mid-arr[i];
                cnt++;
            }
            if(cnt>days) return false;
        }
        return cnt<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE, high = 0;
        for(int el : weights){
            low = Math.max(low, el);
            high+= el;
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(weights, days, mid)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}