class Solution {
    private int helper(List<List<Integer>> triangle,int i,int j,Integer[][] dp){
        int n = triangle.size();
        if(i>=n||j>=n)return Integer.MAX_VALUE;
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=null)return dp[i][j];
        int agla = helper(triangle,i+1,j,dp);
        int agla2 = helper(triangle,i+1,j+1,dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(agla,agla2);


    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(triangle, 0, 0, dp);
    }
}