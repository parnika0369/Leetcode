class Solution {
    private int helper(int m,int n,int i ,int j ,Integer[][] dp){
        if(i==m-1&&j==n-1)return 1;
        if(i==m)return 0;
        if(j==n)return 0;
        if(dp[i][j]!= null)return dp[i][j];
        int down = helper(m,n,i+1,j,dp);
        int right = helper(m,n,i,j+1,dp);
        
        dp[i][j] = down+right;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m+1][n+1];
        return helper(m,n,0,0,dp);
    }
}