class Solution {
    private int helper(String[] strs, int i, int m, int n,Integer[][][] dp) {
        if (i == strs.length) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if(dp[i][m][n] != null){
            return dp[i][m][n];
        }
        int count0 = 0;
        int count1 = 0;
        // char[] arr = new char[str[i].length()];
        // for (int i = 0; i < strs[i].length(); i++) {
        //     arr[i] = strs[i].charAt(i);
        // }
        // for(int i=0;i<strs[i].length();i++){
        //     if(strs.charAt(i)=='1'){
        //         count1++;
        //     }
        //     else{
        //         count0++;
        //     }
        // }
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '1') {
                count1++;
            } else {
                count0++;
            }
        }
        int notTake = helper(strs, i + 1, m, n,dp);
        int take = 0;
        if (m >= count0 && n >= count1) {
            take = 1 + helper(strs, i + 1, m - count0, n - count1,dp);
        }
        dp[i][m][n] = Math.max(notTake, take);
        return dp[i][m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        Integer[][][] dp = new Integer[strs.length+1][m+1][n+1];
        return helper(strs, 0, m, n,dp);
    }
}