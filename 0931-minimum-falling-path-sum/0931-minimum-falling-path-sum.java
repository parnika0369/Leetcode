// class Solution {
//     private int helper(int i,int j,int[][] matrix,int[][] dp){
//         if(i==0 || j==0) return grid[0][0];
//         if (dp[i][j] != -1) return dp[i][j];

//         int moveLeft = helper(i-1,j,matrix,dp);
//         int moveRight = helper(i,j-1,matrix,dp);
//         int moveDiag = helper(i-1,j-1,matrix,dp);

//         return dp[i][j] = matrix[i][j] + Math.min(moveLeft,moveRight,moveDiag);
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int dp[][] = new int[m][n];
//         for(int row : dp){
//             arrays.fill(row,-1);
//         }
//         return helper(m-1,n-1,matrix,dp);
//     }
// }


class Solution {
    private int helper(int i,int j,int[][] matrix,Integer[][] dp){
        if(j < 0 || j >= matrix.length) return Integer.MAX_VALUE;
        if(i==0) return matrix[0][j];
        if (dp[i][j] != null) return dp[i][j];

        int moveLeft = helper(i-1,j-1,matrix,dp);
        int moveRight = helper(i-1,j+1,matrix,dp);
        int moveDiag = helper(i-1,j,matrix,dp);

        return dp[i][j] = matrix[i][j] + Math.min(moveLeft,Math.min(moveRight,moveDiag));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer dp[][] = new Integer[m][n];
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, helper(m-1,j,matrix,dp));
        }
        return min;
    }
}