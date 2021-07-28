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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        int size = 0;
        int rem = 0;
       
       
        if(len<k){
            size = 1;
            rem = 0;
            
        }
        else{
            
            rem = len % k;
            size = (int)(Math.floor(len/k));
        }
       
        ListNode[] nodes = new ListNode[k];
        tmp = head;
        int sizeCounter = 0;
        int index = 0;
        while(tmp != null){
            if(sizeCounter==0){
                nodes[index++] = tmp;
                if(rem>0){
                    tmp = tmp.next;
                    rem--;
                
                }
            }
                       
            
            sizeCounter++; 
            if(sizeCounter == size){
                ListNode next = tmp.next;
                tmp.next = null;
                tmp = next;
                sizeCounter = 0;
            }
            else tmp = tmp.next;
            
        }
        return nodes;
        
        
    }
}
