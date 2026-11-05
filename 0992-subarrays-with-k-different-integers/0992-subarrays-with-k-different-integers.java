class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[]nums,int k){
        int n = nums.length;
        int count =0;
        int left =0;
        int unique =0;
        int[] freq = new int[n+1];
        if(k<0)return 0;
        for(int right =0;right<n;right++){
            if(freq[nums[right]]==0){
                unique++;
            }
            freq[nums[right]]++;
            while(unique>k){
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    unique--;
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}