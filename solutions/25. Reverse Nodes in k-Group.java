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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            len++;
        }
        
        int reverseByKCount=(len/k);
        ListNode dummy=new ListNode(-1);
        return reverse(head,k,reverseByKCount);
        
        
    }
    public ListNode reverse(ListNode node,int k,int reverseCount){
        if(reverseCount==0) return node;
        ListNode left=node;
        int kCopy=k;
        ListNode tmp=node;
        ListNode prev=null;
        ListNode cur=node;
        while(kCopy-->0 && tmp!=null){
            tmp=tmp.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        left.next=reverse(cur,k,reverseCount-1);
        return prev;
    }
}
