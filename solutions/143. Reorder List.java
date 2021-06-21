       
        
    }
    public ListNode reverse(ListNode node){
       
        ListNode iterator=node;
        ListNode prev=null;
        ListNode cur=node;
        while(iterator!=null){
            iterator=iterator.next;
            cur.next=prev;
            prev=cur;
            cur=iterator;
        }
        return prev;
    }
}
/* recursive approch */
/*
class Solution {
    public void reorderList(ListNode head) {
        reorderRecursive(head, head);
        }
    private static ListNode reorderRecursive(ListNode left, ListNode right) {
        if(right == null) {             //even node
            return left;
        }else if(right.next == null) {  //odd node
            ListNode tmp = left.next;
            left.next = null;
            return tmp;
        }
        
        ListNode lead = reorderRecursive(left.next, right.next.next);
        ListNode tmp = lead.next;
        if(left.next == lead) {     //even node
            lead.next = null;
        }else {                     //odd node
            tmp = lead.next;
            lead.next = left.next;
            left.next = lead;
        }
        
        return tmp;
    }
​
}
*/
