class Solution {
    public void reorderList(ListNode head) {
        int len=0;
        ListNode tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            len++;
        }
        if(len<3) return;
        int div=(len/2);
        int k=div + ((len%2)==0?0:1);
       
        ListNode headA= head;
        tmp=headA;
        int kCopy=k-1;
        while(kCopy-->0){
            tmp=tmp.next;
        }
       
        ListNode headB=reverse(tmp.next);
        tmp.next=null;
        tmp=headA;
        ListNode tmp2=headB;
       
        while(k-->0 && headA!=null && headB!=null){
            tmp=tmp.next;
            tmp2=tmp2.next;
            headA.next=headB;
            headB.next=tmp;
            headA=tmp;
            headB=tmp2;
            
        }
    
       
        
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
		if(right == null) {				//even node
			return left;
		}else if(right.next == null) {	//odd node
			ListNode tmp = left.next;
			left.next = null;
			return tmp;
		}
		
		ListNode lead = reorderRecursive(left.next, right.next.next);
		ListNode tmp = lead.next;
		if(left.next == lead) {		//even node
			lead.next = null;
		}else {						//odd node
			tmp = lead.next;
			lead.next = left.next;
			left.next = lead;
		}
		
		return tmp;
	}

}
*/
