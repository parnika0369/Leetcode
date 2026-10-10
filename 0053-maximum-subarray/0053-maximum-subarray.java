class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int Max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum += nums[i];
            Max = Math.max(currSum,Max);
            if(currSum<0){
                currSum = 0;
            }
            
        }
        return Max;
    }
}