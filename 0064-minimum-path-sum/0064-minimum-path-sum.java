class Solution {
    private int helper(int[][] grid,int i,int j,Integer[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(i==m-1&&j==n-1){
            return grid[i][j];
        }
        if (i >= m || j >= n) {
            return 201;
        }
        if(dp[i][j]!= null) return dp[i][j];
        int down = grid[i][j]+helper(grid,i+1,j,dp);
        int right =grid[i][j]+helper(grid,i,j+1,dp);
        dp[i][j] = Math.min(down, right);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m+1][n+1];
        return helper(grid,0,0,dp);

    }
}