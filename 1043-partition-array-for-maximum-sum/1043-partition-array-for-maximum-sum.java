class Solution {
    Integer[] dp;
    private int solve(int i,int[] arr,int k ){
        //base case
        if(i>=arr.length){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int result = Integer.MIN_VALUE;
        
        int Max = -1;
        int len = 0;
        for(int j=i;j<arr.length&& j<i+k ;j++){
            len = j-i+1;
            Max = Math.max(Max, arr[j]);
            int cost = Max*len+solve(j+1,arr,k);
            
            result = Math.max(result,cost);
        }
        return dp[i] = result;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return solve(0,arr,k);//i,arr,k
        
    }
}