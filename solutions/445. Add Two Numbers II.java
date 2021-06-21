class Solution {
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int len1=findLength(l1);
        int len2=findLength(l2);
        int carry=0;
       
        if(len1>=len2){
            carry=addUtil(l1,l2,len1,len2);
        
        }
        else{
            carry=addUtil(l2,l1,len2,len1);
        }
        if(carry!=0){
                ListNode node=new ListNode(carry);
                if(len1>=len2){
                    node.next=l1;
                    return node;
                }
                node.next=l2;
                return node;
         }
        if(len1>=len2){
            
            return l1;
        } 
        
        return l2;
       
    }
    public int findLength(ListNode node){
        ListNode tmp=node;
        int len=0;
        while(tmp!=null){
            tmp=tmp.next;
            len++;
        }
        return len;
    }
   
    public int addUtil(ListNode l1,ListNode l2,int len1,int len2){
        if(len1==len2){
           return addRecursively(l1,l2);
            
        }
     
            int carry=addUtil(l1.next,l2,len1-1,len2);
            return addDigit(l1.val,0,carry,l1);
           
      
    }
    public int addRecursively(ListNode node1,ListNode node2){
        if(node1==null && node2==null) return 0;
        int carry=addRecursively(node1.next,node2.next);
        return addDigit(node1.val,node2.val,carry,node1);
        
        
    }
    public int addDigit(int val1,int val2,int carry,ListNode node){
        int digit=(val1+val2+carry)%10;
        carry=(val1+val2+carry)/10;
        node.val=digit;
        return carry;
    }
    
}
