class Solution {
    public int myAtoi(String s) {
        long ans= 0;
        int i=0;
        int sign= 1;
        int n= s.length();
        while(i<n && s.charAt(i)== ' '){
            i++;
        }
        if(i<n && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(i<n && s.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit= s.charAt(i) - '0';
            if(ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && digit > (sign == 1 ? 7: 8)) return sign==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            ans = ans*10 + digit;
            i++;
        }
        return (int)(sign * ans);
    }
}