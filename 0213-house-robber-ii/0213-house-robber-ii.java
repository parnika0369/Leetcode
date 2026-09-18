import java.util.Arrays;
class Solution {
    private int helper(int[] nums,int start ,int i,Integer[] dp){
        if(i<start) return 0;
        if(dp[i]!= null) return dp[i];
        int chori1 = nums[i]+helper(nums,start,i-2,dp);
        int chori2 = helper(nums,start,i-1,dp);
        dp[i] = Math.max(chori1,chori2);
        return dp[i];

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        Integer[] dp = new Integer[n+1];
        int a = helper(nums,0,n-2,dp);
        Arrays.fill(dp,null);
        int b = helper(nums,1,n-1,dp);
        return Math.max(a,b);
    }
}