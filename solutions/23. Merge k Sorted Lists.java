/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // my sol - 96ms O(nk)
    /*public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        for(int i = 1;i<lists.length;i++){
            lists[0]=merge(lists[0],lists[i]);
            lists[i]=null;
        }
        return lists[0];
    }*/
    // just introduced divide method - 1ms - O(nlogk)
   /* public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        
        return divide(lists,0,lists.length-1);
    }
    private ListNode divide(ListNode[] lists,int start,int end){
        if(start==end) return lists[start];
        int mid = (start+end)/2;
        ListNode A = divide(lists,start,mid);
        ListNode B = divide(lists,mid+1,end);
        return merge(A,B);
    }
    private ListNode merge(ListNode A, ListNode B){
        if(B==null) return A;
        if(A==null) return B;
        ListNode head = null;
        if(A.val<=B.val){
            head = A;
            A=A.next;
        }
        else {
            head = B;
            B = B.next;
        }
        
        ListNode tmp = head;
        while(A!=null && B!=null){
            if(A.val<=B.val){
                 tmp.next = A;
                A = A.next;
                tmp = tmp.next;
            }
            else{
                tmp.next  = B;
                B = B.next;
                tmp = tmp.next;
            }
        }
        if(A!=null){
            tmp.next = A;
        }
        if(B!=null){
            tmp.next = B;
        }
        return head;
        
    }*/
    // 4 ms : using priorityQueue - O(nlogk) - priorityqueue size is k,so operation to add and delete is logk
    // we will the operations n times so, O(nlogk)
     public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
         PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val - b.val);
         
         ListNode dummy = new ListNode();
         ListNode curNode = dummy;
        
         for(ListNode node : lists){
             if(node!=null)
              queue.offer(node);
         }
         while(!queue.isEmpty()){
             ListNode node = queue.poll();
             curNode.next = node;
             curNode = curNode.next;
             if(node.next!=null){
                 queue.offer(node.next);
             }
             
             
         }
         return dummy.next;
     }
    
}
