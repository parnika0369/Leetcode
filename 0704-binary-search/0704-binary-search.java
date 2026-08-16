 /*
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return -1;
    }
}

with recursion
 */

 class Solution{
    public int search(int[] nums,int target){
        int n= nums.length;
        int low =0;
        int high =n-1;
        return helper(nums,target,low,high);

    }
    private int helper(int[] nums,int target,int low,int high){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            return helper(nums,target,mid+1,high);
        }
        else{
            return helper(nums,target,low,mid-1);
        }

    }
 }






