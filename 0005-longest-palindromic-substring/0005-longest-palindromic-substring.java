// class Solution {
//     public String longestPalindrome(String s) {
//         int n = s.length();


//     }
//     private int helper{
//         int maxPalindrome = 0;
//         int palindrome =0;
//         for(int i=0;i<n;i++){
//             int left =i;
//             int right =i;
//             if(s.charAt(left)==s.charAt(right)){
//                 Palindrome++;
//                 left--;
//                 right++;
//             }
//             if(palindrome>maxPalindrome){
//                 maxPalindrome = palindrome;
//             }

//         }
//     }
// }

class Solution{
    public  String longestPalindrome(String s){
        if(s==null || s.length()<2){
            return s;
        }
        int start =0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = helper(s,i,i); //odd
            int len2= helper(s,i,i+1);//even
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int helper(String s, int left, int right) {
    while (left >= 0 &&
           right < s.length() &&
           s.charAt(left) == s.charAt(right)) {

        left--;
        right++;
    }

    return right - left - 1;
}
}