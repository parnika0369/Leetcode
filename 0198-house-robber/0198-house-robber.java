class Solution {
    private int helper(int[] nums,int i,Integer[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!= null)return dp[i];
        int chori1 = nums[i]+helper(nums,i+2,dp);
        int chori2 = helper(nums,i+1,dp);
        dp[i] = Math.max(chori1,chori2);
        return dp[i];
    }
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length+1];
        return helper(nums,0,dp);
    }
} 

