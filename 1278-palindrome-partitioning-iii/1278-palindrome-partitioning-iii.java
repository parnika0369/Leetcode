class Solution {
    Integer[][] dp;
    String p;

    public int palindromePartition(String s, int k) {
        p=s;
        dp = new Integer[s.length()][k+1];
        return solve(0,k);    
    }
    private int palindromeCost(int i, int j){
        int charge =0;
        while(i<j){
            if(p.charAt(i)!=p.charAt(j)){
                charge++;
            }
            i++;
            j--;
        }
        return charge;
    }
    private int solve(int i,int k){
        if(k==1){
            return palindromeCost(i, p.length()-1);

        }
        //if(n-1 == k)
        //return 0;
        if(dp[i][k]!=null)return dp[i][k];
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<=p.length()-k;j++){
            int cost = palindromeCost(i,j)+solve(j+1,k-1);
            ans = Math.min(cost,ans);
        }
        return dp[i][k]= ans;
    }
}