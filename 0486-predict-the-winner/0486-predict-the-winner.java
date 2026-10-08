// class Solution {
//     Integer[][] dp;
//     private int solve(int[] nums, int i, int j) {
//         if (i == j) {
//             return nums[i];
//         }
//         if (dp[i][j] != null) {
//             return dp[i][j];
//         }
//         int left = nums[i]-solve(nums,i+1,j);
//         int right = nums[j]-solve(nums,i,j-1);
//         return dp[i][j] = Math.max(left,right);
//     }
//     public boolean predictTheWinner(int[] nums) {
//         int n = nums.length;
//         dp = new Integer[n][n];
//         return solve(nums, 0, n - 1) >= 0;
//     }
// }


//Second approach to do this question only choosing player 1 part and skipping the player 2 part 


class Solution {
    Integer[][] dp;

    private int solve(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int left = nums[i] + Math.min(
            solve(nums, i + 2, j),
            solve(nums, i + 1, j - 1)
        );

        int right = nums[j] + Math.min(
            solve(nums, i + 1, j - 1),
            solve(nums, i, j - 2)
        );

        return dp[i][j] = Math.max(left, right);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];

        int player1 = solve(nums, 0, n - 1);

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int player2 = total - player1;

        return player1 >= player2;
    }
}