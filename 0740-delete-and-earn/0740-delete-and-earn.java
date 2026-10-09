class Solution {
    Integer[] dp;
    private int solve(int i, int[] points) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int take = points[i] + solve(i - 2, points);
        int skip = solve(i - 1, points);
        return dp[i] = Math.max(take, skip);
    }
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int[] points = new int[max + 1];
        for (int i = 0; i < n; i++) {
            points[nums[i]] += nums[i];
        }
        dp = new Integer[max + 1];
        return solve(max, points);
    }
}