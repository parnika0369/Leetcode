// class Solution {
//     Integer[] dp;
//     private int solve(int[] nums,int i){
//         if(i>=nums.length-1){
//             return 0;
//         }
//         if(dp[i]!=null){
//             return dp[i];
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int j=1;j<=nums[i];j++){
//             int jumps = 1+solve(nums,i+j);
//             ans = Math.min(ans,jumps);
//         }
//         return dp[i] = ans;
//     }
//     public int jump(int[] nums) {
//         dp = new Integer[nums.length];
//         return solve(nums,0);
//     }
// }




class Solution {
    Integer[] dp;
    private int solve(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int sub = solve(nums, i + j);
            if (sub != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + sub);
            }
        }
        return dp[i] = ans;
    }
    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return solve(nums, 0);
    }
}