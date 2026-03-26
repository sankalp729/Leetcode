class Solution {
    public int myAtoi(String s) {
        int i=0;
        int sign = 1;
        long ans = 0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i<s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(i<s.length() && s.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        return parse(s, sign, i, ans);
    }
    public int parse(String s, int sign, int i, long ans){
        if(i == s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(sign * ans);
        }
        if(ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > (sign == 1 ? 7: 8)){
            return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        }
        ans = ans*10 + s.charAt(i) - '0';
        return parse(s, sign, i+1, ans);
    }
}