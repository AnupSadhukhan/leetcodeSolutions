/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode tmp=node;
        while(tmp.next.next!=null){
            tmp.val=tmp.next.val;
            tmp=tmp.next;
        }
        tmp.val=tmp.next.val;
        tmp.next=null;
        
    }
}
