// class Solution {
//     private int helper(char[][] matrix,int m,int n,Integer[][] dp){
//         if(matrix[m][n]==1)return 1;
//         if(dp[m][n]!= null)return dp[m][n];
//         int down = helper(matrix,m-1,n,dp);
//         int left = helper(matrix,m-1,n-1,dp);
//         int diagonal = helper(matrix,m-1,n-1,dp);

//         return dp[m][n]= 1+Math.min(up,Math.min(left,diagonal));
//     }
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         Integer[][] dp = new Integer[m][n];
//         return(matrix,m ,n,dp)
//     }
// }


class Solution {
    private int helper(char[][] matrix, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (matrix[i][j] == '0') {
            return dp[i][j] = 0;
        }
        int up = helper(matrix, i - 1, j, dp);
        int left = helper(matrix, i, j - 1, dp);
        int diagonal = helper(matrix, i - 1, j - 1, dp);
        return dp[i][j] = 1 + Math.min(up, Math.min(left, diagonal));
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                maxSide = Math.max(
                    maxSide,
                    helper(matrix, i, j, dp)
                );
            }
        }
        return maxSide * maxSide;
    }
}