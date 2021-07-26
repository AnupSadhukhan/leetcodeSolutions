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
    //2ms
    /*public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        HashMap<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);
        dummy.next = head;
        int sum = 0;
        ListNode tmp = head;
        while(tmp!=null){
            sum+=tmp.val;
            
            ListNode node = map.get(sum);
            if(node!=null){
                removeFromMap(node,map,sum);
                node.next = tmp.next;
            }
            else map.put(sum,tmp);
            tmp = tmp.next;
        }
        return dummy.next;
        
    }
    private void removeFromMap(ListNode node,HashMap<Integer,ListNode> map,int sum){
        ListNode tmp = node.next;
        if(tmp==null) return;
        int prevSum = sum;
        sum+=tmp.val;
        while(sum!=prevSum){
            map.remove(sum);
            tmp = tmp.next;
            if(tmp==null) break;
            sum+=tmp.val;
        }
    }
    */ 
    // 1ms
      public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int sum = 0;
        for(ListNode i = dummy; i!=null; i = i.next) {
            sum+=i.val;
            map.put(sum, i);
        }
        
        sum = 0;
        for(ListNode i = dummy; i!=null; i = i.next) {
            sum+=i.val;
            i.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
