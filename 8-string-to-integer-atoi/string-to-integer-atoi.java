class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;

        int idx = 0;
        while(idx < s.length() && s.charAt(idx) == ' '){
            idx++;
        }

        int sign = 1;
        if(idx < s.length()){
            if(s.charAt(idx) == '-'){
                sign = -1;
                idx++;
            }
            else if(s.charAt(idx) == '+'){
                sign = 1;
                idx++;
            }
        }
        return parse(s, 0, idx, sign);
    }
    public int parse(String s, long num, int idx, int sign){
        if(idx >= s.length() || !Character.isDigit(s.charAt(idx))) return (int) (sign*num);
        num = num*10 + (s.charAt(idx) - '0');
        if(sign == 1 && num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(sign == -1 && -num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return parse(s, num, idx + 1, sign);
    }
}