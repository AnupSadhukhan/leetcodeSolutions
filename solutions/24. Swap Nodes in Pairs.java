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
    public ListNode swapPairs(ListNode node) {
       if(node==null)
             return null;
        if(node.next==null) return node;
        ListNode node1=node.next;
        if(node1!=null){
            node.next=swapPairs(node1.next);
            node1.next=node;
            
        }
        return node1;
    }
   
}
