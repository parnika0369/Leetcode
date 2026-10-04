// class Solution {
//     private int helper(int[] nums,int i,Integer[] dp){
//         if(i>=nums.length){
//             return 0;
//         }
//         if(dp[i]!= null)return dp[i];
//         int chori1 = nums[i]+helper(nums,i+2,dp);
//         int chori2 = helper(nums,i+1,dp);
//         dp[i] = Math.max(chori1,chori2);
//         return dp[i];
//     }
//     public int rob(int[] nums) {
//         Integer[] dp = new Integer[nums.length+1];
//         return helper(nums,0,dp);
//     }
// } 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        Integer[] dp = new Integer[n];
        dp[0] = nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}