
class Solution {
    Integer[] dp;
    private int solve(String s, int i) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int oneDigit = solve(s, i + 1);
        int twoDigit = 0;
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                twoDigit = solve(s, i + 2);
            }
        }
        dp[i] = oneDigit + twoDigit;
        return dp[i];
    }
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return solve(s, 0);
    }
}
