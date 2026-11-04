class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        int left = 0;
        int Maxw = Integer.MIN_VALUE;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            Maxw = Math.max(Maxw,right-left+1);

        }
        return Maxw;
    }
}