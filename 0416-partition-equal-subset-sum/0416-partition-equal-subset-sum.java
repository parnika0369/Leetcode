class Solution {
    private boolean helper(int[] nums,int i,int k,Boolean[][] dp){
        if(k==0){
            return true;
        }

        if(i>=nums.length)return false;
        if(k<0)return false;
        if(dp[i][k]!=null)return dp[i][k];
        return dp[i][k] = helper(nums,i+1,k,dp) || helper(nums,i+1,k-nums[i],dp);

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        else{
            int a = sum/2;
            Boolean[][] dp = new Boolean[n+1][a+1];
            return helper(nums,0,a,dp);
        }
    }
}