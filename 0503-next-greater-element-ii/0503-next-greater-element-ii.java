class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<2*n;i++){
            int indx = i%n;
            while (!st.isEmpty() && nums[indx] > nums[st.peek()]) {
                ans[st.pop()] = nums[indx];
            }
            if(i<n){
                st.push(indx);
            }
        }
        return ans;
    }
}