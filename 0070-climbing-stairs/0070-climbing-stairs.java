// class Solution {
//     private int helper(int n,Integer[] dp){
//         if(n==0){
//             return 1;
//         }
//         if(n==1){
//             return 1;
//         }
//         if(dp[n]!=null){
//             return dp[n];
//         }
//         dp[n]= helper(n-1,dp)+helper(n-2,dp);
//         return dp[n];
//     }
//     public int climbStairs(int n) {
//         Integer[] dp = new Integer[n+1];
//         return helper(n,dp);
//     }
// }


class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}