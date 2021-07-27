        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode next = null;
        while(tmp!=null){
          prev.next = tmp.next;
          next = tmp.next;
          if(!insert(dummy,len,tmp)){
              prev = tmp;
          }
          
            len++;
           
            tmp = next;
            
        }
        return dummy.next;
    }
    private boolean insert(ListNode dummy,int len,ListNode node){
        ListNode prev = dummy;
        boolean isAddedBefore = false;
        while(len-->0){
            if(prev.next.val>node.val) {
                isAddedBefore = true;
                break;
            }
            prev = prev.next;
        }
        ListNode tmp = prev.next;
        prev.next = node;
        node.next = tmp;
        return isAddedBefore;
        
    }*/
    //2ms
   /* public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy=new ListNode(-1);
        
        dummy.next=head;
        ListNode cur=head;
        ListNode prev=null;
        ListNode temp=null;
        
        while(cur!=null && cur.next!=null){
            if(cur.val<=cur.next.val) {
                cur=cur.next;
            }else{
                temp=cur.next;
                cur.next=cur.next.next;
                prev=dummy;
                while(prev.next.val<temp.val){
                    prev=prev.next;
                }
                temp.next=prev.next;
                prev.next=temp;
            }
        }
        return dummy.next;
    }
    */
    // using merge sort technique 0 ms
    public ListNode insertionSortList(ListNode head) {
      if(head==null || head.next==null)
            return head;
            
        // Finding the mid of the linked list and breaking the the list in two parts
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        mid=mid.next;
        slow.next=null;
        
        //recursive calls to sort the 2 seperated lists
        ListNode a=insertionSortList(head);
        ListNode b=insertionSortList(mid);
        
        //merging the 2 sorted lists
        return merge(a,b);
    }
    public ListNode merge(ListNode a,ListNode b){
        if(a==null) return b;
        if(b==null) return a;
