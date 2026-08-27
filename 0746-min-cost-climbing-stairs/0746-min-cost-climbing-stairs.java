// class Solution {
//     private int helper(int[] cost,int i){
//         if (i >= cost.length) return 0;
//         int step1= helper(cost,i+1);
//         if(i>=2){
//             int step2 = helper(cost,i+2);
//         }
//         return cost[i]+Math.min(step1,step2);

//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         // return helper(cost,n);
//         return Math.min(helper(cost, 0), helper(cost, 1));
//     }
// }

class Solution {
    private int[] dp;
    private int helper(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (dp[i] != -1) return dp[i];
        int step1 = helper(cost, i + 1);
        int step2 = helper(cost, i + 2);
        return dp[i] = cost[i] + Math.min(step1, step2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+2];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }
}