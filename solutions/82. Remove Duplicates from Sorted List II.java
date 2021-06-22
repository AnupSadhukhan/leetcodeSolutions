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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp=head;
        ListNode duplicate=null;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        tmp=dummy;
        while(tmp!=null){
            duplicate=tmp.next;
            if(duplicate!=null && duplicate.next!=null && duplicate.val==duplicate.next.val){
                while(duplicate!=null && duplicate.next!=null && duplicate.val==duplicate.next.val){
                    duplicate=duplicate.next;
                }
                tmp.next=duplicate.next;
            }
            else{
                tmp=tmp.next;
            }
                
        }
        return dummy.next;
    }
}
