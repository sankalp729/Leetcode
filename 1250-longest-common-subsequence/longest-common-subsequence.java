class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length()-1, idx2= text2.length()-1;
        int[][] dp = new int[idx1+1][idx2+1];
        if(text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1;
        for(int i=1; i<=idx1; i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1; i<=idx2; i++){
            if(text1.charAt(0) == text2.charAt(i)){
                dp[0][i] = 1;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1; i<=idx1; i++){
            for(int j=1; j<=idx2; j++){
                if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1+dp[i-1][j-1];

                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[idx1][idx2];
    }
}