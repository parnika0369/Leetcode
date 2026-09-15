class Solution {
    private int helper(int i,int j,String s1, String s2,Integer[][] dp){
        if(i==0 || j==0){
            return 0;
        }
        if((dp[i][j])!= null) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = 1+ helper(i-1,j-1,s1,s2,dp);
        }
        else{
            dp[i][j] = Math.max(helper(i,j-1,s1,s2,dp),helper(i-1,j,s1,s2,dp));
        }

        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        Integer[][] dp = new Integer[m+1][n+1];
        return helper(m,n,text1,text2,dp);
    }
}