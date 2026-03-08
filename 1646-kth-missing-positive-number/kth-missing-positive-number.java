class Solution {
    public int findKthPositive(int[] arr, int k) {
        // brute force : k will increase for all the numbers lesser than k in the array and then we will return k!
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= k) k++;
        }
        return k;
    }
}