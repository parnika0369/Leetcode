//space optimiation!
class Solution {
    public int climbStairs(int n) {
        // Integer[] dp = new Integer[n+1];
        // dp[0]=1;
        // dp[1]=1;
        int dp0 = 1;
        int dp1 =1;
        int dpn = 0;
        for(int i=2;i<n+1;i++){
            dpn = dp0;
            dp0 = dp1;
            dp1= dpn+dp0;
        }
        return dp1;
    }
}