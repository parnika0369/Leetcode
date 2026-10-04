// class Solution {
//     private int helper(int n,int[] cost,Integer[] dp){
//         if(n==0||n==1){
//             return 0;
//         }
//         if(dp[n]!=null)return dp[n];
//         int StepOne = helper(n-1,cost,dp)+cost[n-1];
//         int StepTwo = helper(n-2,cost,dp)+cost[n-2];
//         return dp[n] = Math.min(StepOne,StepTwo);
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         Integer[] dp = new Integer[n+1];
//         return helper(n,cost,dp);
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n+1];
        dp[0]=0;
        dp[1]=0;
        int Step1=0;
        int Step2 =0;
        for(int i=2;i<n+1;i++){
            Step1 = cost[i-1]+dp[i-1];
            Step2 = cost[i-2]+dp[i-2];
            dp[i] = Math.min(Step1,Step2);
        }
        return dp[n];
    }
}