class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m+1][n+1];
        if(n==1&&m==1){
            if(obstacleGrid[m-1][n-1]==1){
                return 0;
            }
            else{
                return 1;
            }
        }
        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }
        if (obstacleGrid[0][0] == 0) {
            dp[1][1] = 1;
        } else {
            dp[1][1] = 0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==1&&j==1){
                    continue;
                }
                if(obstacleGrid[i-1][j-1]==1){
                    dp[i][j] = 0;
                }
                
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}