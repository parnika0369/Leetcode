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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int ans[] = new  int[count];
        for(int i=0;i<count;i++){
            ans[i] = temp.val ;
            temp = temp.next;
        }
        Arrays.sort(ans);
        ListNode node = new ListNode(ans[0]);
        ListNode temp2 = node;
        for(int i=1;i<count;i++){
            ListNode tempNode = new ListNode(ans[i]);
            temp2.next = tempNode;
            temp2 = temp2.next;
        }
        return node;
    }
}