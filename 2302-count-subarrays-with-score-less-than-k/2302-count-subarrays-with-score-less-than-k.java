class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;
        int left = 0;
        long sum =0;
        // int score =1;
        // int Maxw = Integer.MIN_VALUE;
        for(int right=0;right<n;right++){
            sum = sum+nums[right];
            // score = sum*right;
            // while(score<k){     
            // }
            while(sum*(right-left+1)>=k){
                sum = sum-nums[left];
                left++;
            }
            count = count + right-left+1;
        }
        return count;
    }
}