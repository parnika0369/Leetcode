class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            while(!st.isEmpty()&&nums2[i]>st.peek()){
                map.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        // Numbers left in the stack have no greater element
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }
        //final ans in O(1)
        for(int i=0;i<n;i++){
            ans[i] = map.get(nums1[i]);

        }
        return ans;
    }
}