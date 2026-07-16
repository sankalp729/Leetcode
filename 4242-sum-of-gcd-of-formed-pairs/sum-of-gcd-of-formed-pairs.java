class Solution {
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mxi = new int[n];
        mxi[0] = nums[0];
        for(int i=1; i<n; i++){
            mxi[i] = Math.max(nums[i], mxi[i-1]);
        }
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = gcd(nums[i], mxi[i]);
        }
        Arrays.sort(p);
        long sum = 0;
        int i=0, j= n-1;
        while(i<j){
            sum+= gcd(p[i], p[j]);
            i++;
            j--;
        }
        return sum;
    }
}