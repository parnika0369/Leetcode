// class Solution {
//     private int helper(int[] nums,int i,Integer[] dp){
//         if(i>= nums.length)return 0;
//         if(dp[i]!=null)return dp[i];
//         int skip = helper(nums,i+1,dp);
//         int NotSkip = nums[i]+helper(nums,i+2,dp);
//         dp[i] = math.max(skip,NotSkip);
//         return dp[i];  
//     }
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         int[] freq = new int[n];
//         for(int i=0;i<n;i++){
//             int count =0;
//             if(nums[i]==nums[i+1]){
//                 count++;
//                 freq[i]= count;
//             }
//         }
//         Integer[] dp = new Integer[n];
//         helper(int[] nums,0,dp);
//     }
// }
class Solution {
    private int helper(int[] points, int i, Integer[] dp) {
        if (i >= points.length) return 0;
        if (dp[i] != null) return dp[i];
        int skip = helper(points, i + 1, dp);
        int take = points[i] + helper(points, i + 2, dp);
        dp[i] = Math.max(skip, take);
        return dp[i];
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] points = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            points[nums[i]] += nums[i];
        }
        Integer[] dp = new Integer[max + 1];
        return helper(points, 0, dp);
    }
}

