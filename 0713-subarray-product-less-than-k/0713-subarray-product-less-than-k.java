class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n = nums.length;
        int r =0;
        int l =0;
        int prod =1;
        int count =0;
        for(r=0;r<n;r++){
            prod =prod*nums[r];
            while(prod>=k){
                prod = prod/nums[l];
                l++;
            }
            count = count+(r-l+1);      // to count no of subarray in sliding window 
        }
        return count ; 
    }
}