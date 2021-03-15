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
    public ListNode swapNodes(ListNode head, int k) {
        if(k==0 || head==null) return head;
       /* ListNode firstK=head;
        ListNode lastK=head;
        ListNode tmp=head,tmp1=null,tmp2=null;
        int k1=k,k2=k;
        while(tmp.next!=null){
            if(k1==2)tmp1=tmp;
            if(k1==1){
                firstK=tmp;
            } 
             k1--;
          if(k2<=2){
              tmp2=lastK;
          }
           if(k2<=1){
               lastK=lastK.next;
           }
             k2--;
            tmp=tmp.next;
