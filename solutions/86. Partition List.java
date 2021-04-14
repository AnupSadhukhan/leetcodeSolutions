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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode before=new ListNode(-1);
        ListNode tmp=before;
        before.next=head;
        while(before!=null && before.next!=null && before.next.val<x){
            before=before.next;
        }
        if(before==null || before.next==null) return head;
        
        ListNode after=before.next;
        // while(after!=null && after.val!=x){
        //     after=after.next;
        // }
        while(after!=null && after.next!=null){
           if(after.next.val<x){
               ListNode node=after.next;
               after.next=node.next;
               node.next=before.next;
               before.next=node;
               before=before.next;
               
           }
           else after=after.next;
        }
        return tmp.next;
    }
}
