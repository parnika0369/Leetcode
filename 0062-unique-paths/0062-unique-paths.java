// class Solution {
//     private int helper(int i,int j){
//         if(i<0||j<0){
//             return 0;
//         }
//         if(i==0 && j==0){
//             return 1;
//         }
//         int up = helper(i-1,j);
//         int left = helper(i,j-1);
//         return up+left;
//     }
//     public int uniquePaths(int m, int n) {
//         helper(m-1,n-1);
//     }
// }

class Solution {
    private int helper(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = helper(i-1, j, dp) + helper(i, j-1, dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(m-1, n-1, dp);
    }
}