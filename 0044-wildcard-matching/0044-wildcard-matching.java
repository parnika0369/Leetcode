class Solution {
    private boolean helper(String s,String p,int i,int j,Boolean[][] dp){
        if(i==0&&j==0)return true ;
        if (j == 0) return false;
        if (i == 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j]!= null) return dp[i][j];
        boolean a=false,b=false,c=false;

        if(s.charAt(i-1)==p.charAt(j-1)){
            a =  helper(s,p,i-1,j-1,dp);
        }
        if(p.charAt(j-1)=='*'){
            b = helper(s,p,i,j-1,dp) || helper(s,p,i-1,j,dp) ;
        }
        if(p.charAt(j-1)=='?'){
            c = helper(s,p,i-1,j-1,dp);
        }
        return dp[i][j] = (a || b || c);
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean [][] dp = new Boolean[n+1][m+1];
        return helper(s,p,n,m,dp);
    }
}