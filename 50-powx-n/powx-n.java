class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(m < 0){
            m = -m;
            x = 1/x;
        }
        double ans = 1;
        while(m>0){
            if(m%2 == 0){
                m = m/2;
                x = x*x;
            }
            else{
                ans = ans*x;
                m = m-1;
            }
        }
        return ans;
    }
}