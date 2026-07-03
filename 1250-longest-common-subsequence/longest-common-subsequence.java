class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length(), idx2= text2.length();
        int[][] dp = new int[idx1+1][idx2+1];
        for(int i=1; i<=idx1; i++){
            for(int j=1; j<=idx2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i =idx1, j =idx2;
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] >= dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(sb.reverse());
        return dp[idx1][idx2];
    }
}