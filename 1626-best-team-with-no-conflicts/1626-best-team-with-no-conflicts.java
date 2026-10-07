class Solution {
    int [][] players;
    Integer[] dp;
    private int solve(int i){
        if(dp[i]!=null){
            return dp[i];
        }
        int ans = players[i][1];
        for(int j=0;j<i;j++){
            if(players[j][1] <= players[i][1]){
                ans = Math.max(ans,solve(j) + players[i][1]);
            }
        }
        return dp[i] = ans;
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        players = new int[n][2];
        for(int i=0;i<n;i++){
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players,(a,b)->{
            if(a[0] == b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        dp = new Integer[n];
        int ans =0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,solve(i));
        }
        return ans;
    }
}