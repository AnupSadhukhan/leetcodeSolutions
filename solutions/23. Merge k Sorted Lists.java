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
