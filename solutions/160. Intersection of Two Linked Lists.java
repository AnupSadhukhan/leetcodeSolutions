/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
       // ListNode ins=null;
        if(A==null || B==null ) return null;
        if(A==B) return new ListNode(A.val);
       // boolean switchA=false;
        //boolean SwitchB=false;
        while(A!=null && B!=null){
            
            if(A==B) return new ListNode(A.val);
            A=A.next;
            B=B.next;
        }
        if(A==null) A=headB;
        if(B==null) B=headA;
        while(A!=null && B!=null){
            if(A==B) return new ListNode(A.val);
            A=A.next;
            B=B.next;
        }
        if(A==null) A=headB;
            
