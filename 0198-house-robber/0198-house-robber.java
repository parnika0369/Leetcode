// class Solution {
//     private int chori(int[] nums,int i,int[] dp){
//         if(i>=nums.length){
//             return 0;
//         }
//         if(dp[i] != -1){
//             return dp[i];
//         }
//         int choriFrom0 = nums[i] + chori(nums,i+2,dp);
//         int choriFrom1 = chori(nums,i+1,dp);
//         return dp[i] =  Math.max(choriFrom0,choriFrom1);
//     }
//     public int rob(int[] nums) {
//         int i = 0;
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp,-1);
//         return chori(nums,i,dp);
//     }
// }


//tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int choriFrom0 = nums[i] + dp[i - 2];
            int choriFrom1 = dp[i - 1];
            dp[i] = Math.max(choriFrom0, choriFrom1);
        }
        return dp[n - 1];
    }
}