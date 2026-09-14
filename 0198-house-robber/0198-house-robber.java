class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        // Integer[] dp = new Integer[n+1];
        int choriONzero = nums[0];
        int choriONone = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp = choriONone;
            choriONone = Math.max((nums[i]+choriONzero),choriONone);
            choriONzero = temp;
        }
        return choriONone;
    }
}