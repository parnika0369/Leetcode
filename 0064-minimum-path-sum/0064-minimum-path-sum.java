// class Solution {
//     private int helper(int i,int j,int[][] grid, int[][] dp){
//         if (i == 0 && j == 0) return grid[0][0];
//         if (i < 0 || j < 0) return Integer.MAX_VALUE;

//         if (dp[i][j] != -1) return dp[i][j];
//         int Moveright = grid[i][j]+helper(i-1,j,grid,dp);
//         int MoveDown = grid[i][j]+helper(i,j-1,grid,dp);

//         return dp[i][j] = Math.min(Moveright,MoveDown);
//     }
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n= grid[0].length;
//         int dp[][] = new int[m][n];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         return helper(m-1,n-1, grid,dp);
//     }
// }




class Solution {
    private int helper(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int fromTop  = helper(i - 1, j, grid, dp);
        int fromLeft = helper(i, j - 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(fromTop, fromLeft);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(m - 1, n - 1, grid, dp);
    }
}