class Solution {

    private Boolean[] dp;

    private boolean helper(int[] nums, int i) {

        if (i >= nums.length - 1) {
            return true;
        }

        if (nums[i] == 0) {
            return false;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        for (int j = 1; j <= nums[i]; j++) {
            boolean ans = helper(nums, i + j);

            if (ans) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return helper(nums, 0);
    }
}