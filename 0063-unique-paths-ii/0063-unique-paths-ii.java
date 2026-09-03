class Solution {
    private int helper(int i, int j, Integer[][] dp, int[][] obstacleGrid) {
        if (i < 0 || j < 0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != null) return dp[i][j];
        int down = helper(i - 1, j, dp, obstacleGrid);
        int right = helper(i, j - 1, dp, obstacleGrid);
        return dp[i][j] = down + right; 
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        return helper(m - 1, n - 1, dp, obstacleGrid);
    }
}