// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         if(n>m)return false;
//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];
//         for(int i=0;i<n;i++){
//             freq1[s1.charAt(i) - 'a']++;
//         }
//         int left = 0;
//         for(int right =0;right<m;right++){
//             freq2[s2.charAt(right)-'a']++;
//             if(right - left + 1 > n) {
//                 freq2[s2.charAt(left) - 'a']--;
//                 left++;
//             }
//             for(int c = 0; c < 26; c++) {
//                 if(freq1[c] != freq2[c]) {
//                     return false;
//                 }
//             }
//             return true;
//         }
//     }
// }





class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < m; right++) {
            freq2[s2.charAt(right) - 'a']++;
            if(right - left + 1 > n) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            boolean match = true;
            for(int c = 0; c < 26; c++) {
                if(freq1[c] != freq2[c]) {
                    match = false;
                    break;
                }
            }
            if(match) return true;
        }
        return false;
    }
}
