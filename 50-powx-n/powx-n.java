class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(m<0){
            x = 1/x;
            m = -m;
        }
        double ans = 1;
        while(m != 0){
            if(m%2 == 0){
                x = x*x;
                m = m/2;
            }else{
                ans = ans*x;
                m = m-1;
            }
        }
        return ans;
    }
}