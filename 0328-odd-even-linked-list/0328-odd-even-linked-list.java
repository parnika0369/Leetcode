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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode check = head.next;
        ListNode even=  check;
        while(check!=null&&check.next!=null){
            temp.next = check.next;
            temp = temp.next;
            check.next = temp.next;
            check = check.next;
        }
        temp.next = even;
        return head;
    }
}