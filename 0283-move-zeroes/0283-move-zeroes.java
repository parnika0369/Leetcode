// class Solution {
//     public void moveZeroes(int[] nums) {
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]==0){
//                 int j= i;
//                 while(j<nums.length-1){
//                     int temp = nums[j];
//                     nums[j]= nums[j+1];
//                     nums[j+1] = temp;
//                     j++;
//                 }
//                 i--;
//             }
//         }
//     }
// }


class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
