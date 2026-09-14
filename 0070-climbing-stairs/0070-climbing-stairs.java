class Solution {
    private int helper(int n,Integer[] dp){
        if(n<0)return 0;
        if(n==0){
            return 1;
        }
        if(dp[n]!=null)return dp[n];
        dp[n] = helper(n-1,dp)+ helper(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return helper(n,dp);
    }
}