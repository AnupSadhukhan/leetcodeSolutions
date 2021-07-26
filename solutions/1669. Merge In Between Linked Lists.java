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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // remove ath node to bth node
        ListNode prevA = null, ANode = null;
        ListNode nextB = null, BNode = null;
        int i = 0;
        ListNode tmp = list1;
        while(tmp!=null){
            if(i==a-1){
                prevA =  tmp;
            }
            else if(i==a){
                ANode = tmp;
            }
            if(i==b+1){
                nextB = tmp;
            }
            else if(i==b){
                BNode = tmp;
            }
            i++;
            tmp = tmp.next;
        }
        if(ANode==null || BNode==null) return list1;
        
        prevA.next = list2;
        if(nextB == null ) return list1;
       
        ListNode tail = list2;
        
        while(tail.next!=null){
            tail = tail.next;
        }
        
        tail.next = nextB;
        
        return list1;
    }
    
}
