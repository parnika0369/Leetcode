class Solution {
    String s;
    Integer[] dp;
    int n;

    public boolean isPalindrome(int i ,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int solve(int i){
        if(i==n){
            return -1;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j)){
                int cuts = 1+solve(j+1);
                ans = Math.min(ans,cuts);
            }
        }
        return dp[i] = ans;
    }


    public int minCut(String s) {
        this.s = s;
        this.n = s.length();
        dp = new Integer[n];
        return solve(0);
    }
}