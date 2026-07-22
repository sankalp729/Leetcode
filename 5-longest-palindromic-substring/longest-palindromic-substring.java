class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int even = exp(s, i, i);
            int odd = exp(s, i, i+1);
            int len = Math.max(even, odd);
            if(len>(end-start+1)){
                start = i-(len-1)/2;
                end = i+(len)/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int exp(String s, int l, int r){
        int n = s.length();
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}