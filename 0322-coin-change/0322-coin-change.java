class Solution {
    private int helper(int[] coins,int amount,Integer[] dp){
        if(amount==0)return 0;
        if(amount<0)return -1;
        if(dp[amount]!=null){
            return dp[amount];
        }
        int count = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int temp = helper(coins,amount-coins[i],dp);
            if(temp!=-1){
                count = Math.min(count,temp+1);
            }
        }
        if(count == Integer.MAX_VALUE){
            return dp[amount] = -1;
        }
        return dp[amount] = count;
    }
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount+1];

        return helper(coins,amount,dp);
    }
}