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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int half = 0;
        half = count/2;
        
        while(half-->1){
            temp = temp.next;
        }
        if(temp.next!=null && temp.next.next!=null){
            temp.next = temp.next.next;
        }
        else{
            temp.next = null;
        }
        return head;
    }
}