/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if(head == null || head.next == null) return true;
//         ListNode temp = head;
//         ListNode check  = head;
//         int count =0;
//         while(temp!= null){
//             count++;
//             temp = temp.next;
//         }
//         temp = head;
//         int half = 0;
//         if(count%2==0){
//             half = count/2 ;
//         }
//         else{
//             half = count/2+1;
//         }
//         while(half-->0){
//             check = check.next;
//         }
//         while(check!=null){
//             if(temp.val!=check.val){
//                 return false;
//             }
//             temp= temp.next;
//             check  = check.next;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode temp = head;
        ListNode check = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        temp = head;
        int half = 0;

        if(count % 2 == 0){
            half = count / 2;
        }
        else{
            half = count / 2 + 1;
        }

        while(half-- > 0){
            check = check.next;
        }

        // Reverse the second half
        ListNode prev = null;
        while(check != null){
            ListNode next = check.next;
            check.next = prev;
            prev = check;
            check = next;
        }

        check = prev;

        // Compare both halves
        while(check != null){
            if(temp.val != check.val){
                return false;
            }
            temp = temp.next;
            check = check.next;
        }

        return true;
    }
}