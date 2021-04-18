/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode fast=head;
        ListNode last=new ListNode(-1);
        last.next=head;
        while(fast!=null){
            if(n<=0){
                last=last.next;
               
            }
             fast=fast.next;
                n--;
        }
        if(last.next==head) return head.next;
        last.next=last.next==null?null:last.next.next;
        return head;
    }
}
