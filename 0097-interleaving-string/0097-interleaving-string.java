class Solution {
    private boolean helper(String s1,String s2,String s3,int i,int j,Boolean[][] dp){
        if(i==0&&j==0){
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean first = false;
        boolean two = false;
        if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1)){
            first = helper(s1,s2,s3,i-1,j,dp);
        }
        if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1)){
            two = helper(s1,s2,s3,i,j-1,dp);
        }
        dp[i][j] =  (first||two);
        return dp[i][j];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();
        if(m+n != o){
            return false;
        }
        Boolean[][] dp = new Boolean[n+1][m+1];
        return helper(s1,s2,s3,n,m,dp);
    }
}