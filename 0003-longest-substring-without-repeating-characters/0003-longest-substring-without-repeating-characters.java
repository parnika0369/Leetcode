class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int left = 0;
        int Maxw =0;
        for(int right = 0;right<n;right++){
            char c = s.charAt(right);
            freq[c]++;                 // frequency array count the value 
            while(freq[c]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            Maxw = Math.max(Maxw,right-left+1);
        }
        return Maxw;
    }
}