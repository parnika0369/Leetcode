class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int Wsize = 0;
        int sum =0;
        int left =0;
        int minW =Integer.MAX_VALUE;
        for(int right =0;right<n;right++){
            sum = sum+nums[right];
            while(sum>=target){
                Wsize = right - left + 1;
                minW = Math.min(minW, Wsize);
                sum = sum - nums[left];
                left++;
            }   
        }
        return minW == Integer.MAX_VALUE ? 0 : minW;
    }
}
