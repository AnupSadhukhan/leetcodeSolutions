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
    public boolean isPalindrome(ListNode head) {
        
        // O(n) O(n)
        /*
        if(head==null) return  false;
        ListNode tmp=head;
        int len=0;
        List<Integer> list=new ArrayList<>();
        while(tmp!=null){
            len++;
            list.add(tmp.val);
            tmp=tmp.next;
        }
        int left=0;
        int right=len-1;
        while(left<right){
            if(list.get(left++)!=list.get(right--)) return false;
        }
        return true;*/
        
        if(head==null) return false;
        if(head.next==null) return true;
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode tmp=slow;
        int len=2;
        while(fast!=null && fast.next!=null){
            tmp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=tmp;
            if(fast.next!=null){
                len++;
                fast=fast.next;
            }
            if(fast.next!=null){
                len++;
                fast=fast.next;
            }
        }
