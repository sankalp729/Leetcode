class Solution {
    public int rec(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1<0 || i2<0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)) return dp[i1][i2] = 1+rec(i1-1, i2-1, s1, s2, dp);
        
        return dp[i1][i2] = Math.max(rec(i1-1, i2, s1, s2, dp), rec(i1, i2-1, s1, s2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length()-1, idx2= text2.length()-1;
        int[][] dp = new int[idx1+1][idx2+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(idx1, idx2, text1, text2, dp);
    }
}