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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count =0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int half = 0;
        if(half%2==0){
            half = count/2;
        }
        else{
            half = count/2 +1;
        }
        temp = head;
        while(half-->0){
            temp = temp.next;
        }
        return temp;
    }
}