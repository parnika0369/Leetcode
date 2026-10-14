class Solution {
    Integer[][] dp;
    private int solve(int[] nums ,int i,int k){
        int n = nums.length;
        //base case
        if(k==1){  //only one partition left 
            int sum =0;
            for(int t=i;t<n;t++){
                sum+=nums[t];
            }
            return sum;
        }
        if (dp[i][k] != null) {
            return dp[i][k];
        }
        int currSum =0;
        int result = Integer.MAX_VALUE;
        for(int j=i;j<=n-k;j++){         //n-k is important 
            currSum = currSum +nums[j];
            int remainingSum = solve(nums,j+1,k-1);
            int LargestSum= Math.max (currSum , remainingSum);
            result = Math.min(result,LargestSum);
        }
        return dp[i][k] = result ;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        dp = new Integer[n][k+1]; //why n and k+1 ? 
        return solve(nums,0,k);
    }
}