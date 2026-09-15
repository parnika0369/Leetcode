class Solution {
    private int helper(int[] nums1,int[] nums2,int i,int j,Integer[][] dp){
        if(i==0||j==0){
            return 0;
        }
        if(dp[i][j]!= null) return dp[i][j];
        if(nums1[i-1]==nums2[j-1]){
            dp[i][j] = 1 + helper(nums1,nums2,i-1,j-1,dp);  
        }
        else{
            dp[i][j] = Math.max(helper(nums1,nums2,i-1,j,dp),helper(nums1,nums2,i,j-1,dp));
        }
        return dp[i][j];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Integer[][] dp = new Integer[n+1][m+1];
        return helper(nums1,nums2,n,m,dp);
    }
}