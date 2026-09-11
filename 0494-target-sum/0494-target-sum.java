class Solution {
    private int helper(int[] nums,int target ,int i,int sum,int ofset,Integer[][] dp){
        if(i==nums.length){
            if(sum == target)
                return 1;
            return 0;
        }
        if(dp[i][sum+ofset]!= null)return dp[i][sum+ofset];

        int take = helper(nums,target , i+1,sum+nums[i],ofset,dp);
        int notTake = helper(nums,target ,i+1,sum-nums[i],ofset,dp);
        dp[i][sum+ofset]= take + notTake;
        return dp[i][sum+ofset];

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        int SUM = 0;
        for(int i=0;i<n;i++){
            SUM += nums[i];
        }
        Integer[][] dp = new Integer[n+1][2*SUM+1];
        return helper(nums,target,0,0,SUM,dp);
    }
}