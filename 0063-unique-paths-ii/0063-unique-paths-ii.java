class Solution {
    private int helper(int[][] obstacleGrid,int i,int j,Integer[][] dp){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(i==m) return 0;
        if(j==n)return 0;
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==m-1&&j==n-1)return 1;
        if(dp[i][j]!= null) return dp[i][j];
        
        int down = helper(obstacleGrid,i+1,j,dp);
        int right = helper(obstacleGrid,i,j+1,dp);
        dp[i][j] = down + right;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        return helper(obstacleGrid,0,0,dp);
    }
}