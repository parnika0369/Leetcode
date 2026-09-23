class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Integer[] dp = new Integer[n];
        for(int i=0;i<n;i++){
            ans = Math.max(ans,helper(i,nums,dp));
        }
        return ans;
    }
    private int helper(int i,int[] nums,Integer[] dp){
        
        if (dp[i] != null) {
            return dp[i];
        }
        int ans = 1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                ans = Math.max(ans,1+helper(j,nums,dp));
            }
        }
        return dp[i]=ans;
    }
}