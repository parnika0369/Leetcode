class Solution {
    Integer[] dp;
    private int solve(int[] nums,int i,int j){
        if(i>j){
            return 0;
        }
        if(dp[i]!=null)return dp[i];
        int chori1 = nums[i]+solve(nums,i+2,j);
        int chori2 = solve(nums,i+1,j);
        dp[i] = Math.max(chori1,chori2);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        dp = new Integer[n];
        int one =  solve(nums,0,nums.length-2);
        dp = new Integer[n];
        int two =  solve(nums,1,nums.length-1);
        return Math.max(one, two);
    }
}



