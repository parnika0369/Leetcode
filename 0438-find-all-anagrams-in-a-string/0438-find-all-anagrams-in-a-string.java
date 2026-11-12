// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> ans = new ArrayList<>();
//         int n = s.length;
//         int m = p.length;
//         if(m<n)return ans;
//         int[] freq = new int[26];
//         for(int i=0;i<m;i++){
//             freq[p.charAt(i)-'a']++;
//         }
//         int left =0;
//         for(int right=0;right<n;right++){

//         }
//     }
// }


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) return ans;
        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']--;
            if (right - left + 1 > m) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == m) {
                boolean valid = true;
                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
