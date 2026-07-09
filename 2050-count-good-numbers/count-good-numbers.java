class Solution {
    long mod = (long)(1e9 + 7);
    public long myPow(long x, long n) {
        long m = n;
        if(m<0){
            x = 1/x;
            m = -m;
        }
        long ans = 1;
        while(m != 0){
            if(m%2 == 0){
                x = (x*x)%mod;
                m = m/2;
            }else{
                ans = (ans*x)%mod;
                m = m-1;
            }
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2, odd = n/2;
        return (int)((myPow(5, even) * myPow(4, odd))%mod);
    }
}