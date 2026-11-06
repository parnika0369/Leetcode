class Solution {
    int m;
    int n;
    Integer[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new Integer[m+1][n+1];
        return solve(0,0,dungeon);
    }
    public int solve(int i,int j,int[][]dungeon){
        if(i>=m||j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return Math.max(1,1-dungeon[i][j]);
        }
        if(dp[i][j]!=null)return dp[i][j];
        int right = solve(i,j+1,dungeon);
        int down = solve(i+1,j,dungeon);
        int need = Math.min(right,down);
        return dp[i][j]= Math.max(1,need-dungeon [i][j]);
    }
}