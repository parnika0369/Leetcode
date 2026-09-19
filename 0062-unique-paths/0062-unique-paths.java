// class Solution {
//     private int helper(int m,int n,int i ,int j ,Integer[][] dp){
//         if(i==m-1&&j==n-1)return 1;
//         if(i==m)return 0;
//         if(j==n)return 0;
//         if(dp[i][j]!= null)return dp[i][j];
//         int down = helper(m,n,i+1,j,dp);
//         int right = helper(m,n,i,j+1,dp);
        
//         dp[i][j] = down+right;
//         return dp[i][j];
//     }
//     public int uniquePaths(int m, int n) {
//         Integer[][] dp = new Integer[m+1][n+1];
//         return helper(m,n,0,0,dp);
//     }
// }
class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }
        dp[1][1]=1;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==1&&j==1){
                    continue;
                }
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}