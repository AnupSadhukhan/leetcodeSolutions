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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        int len=0;
        ListNode tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            len++;
        }
       
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode res=dummy;
        int leftPoint=left;
        while(left-1>0 && left<len){
            dummy=dummy.next;
            left--;
        }
        //System.out.println("left " +left);
        dummy.next=reverseTillK(dummy.next,right-leftPoint+1);
        return res.next;
        
    }
   // -1->1->2
    public ListNode reverseTillK(ListNode node,int k){
        //System.out.println(node.val+" k: "+k);
        ListNode tmp=node;
        ListNode left=node;
        ListNode cur=node;
        ListNode prev=null;
        while(k>0 && tmp!=null){
            tmp=tmp.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
            //System.out.println("running "+k);
            k--;
         
            
        }
        left.next=tmp;
        return prev;
    }
}
