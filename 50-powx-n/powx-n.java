class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(m < 0){
            m = -m;
            x = 1/x;
        }
        double ans = 1;
        while(m > 0){
            if(m%2 == 0){
                x = x*x;
                m = m/2;
            }else{
                m = m-1;
                ans = ans*x;
            }
        }
        return ans;
    }
}