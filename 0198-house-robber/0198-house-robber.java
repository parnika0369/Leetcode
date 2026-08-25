class Solution {
    private int chori(int[] nums,int i,int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int choriFrom0 = nums[i] + chori(nums,i+2,dp);
        int choriFrom1 = chori(nums,i+1,dp);
        return dp[i] =  Math.max(choriFrom0,choriFrom1);
    }
    public int rob(int[] nums) {
        int i = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return chori(nums,i,dp);
    }
}

