            //System.out.println("loop - 2");
            while(!stack.empty() && stack.peek()<=tmp.val){
                stack.pop();
            }
            res[i] = stack.empty()? 0 : stack.peek();
            stack.push(tmp.val);
            i--;
            tmp = tmp.next;
        }
        return res;
    }
    private ListNode reverse(ListNode head){
         ListNode prev = null;
        ListNode tmp = head;
        while(tmp!=null){
            head = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = head;
        }
       return prev; 
    
   
    }
    */
    // 7 ms
//     public int[] nextLargerNodes(ListNode head) {
//         int len=0;
//         ListNode tmp = head;
//         while(tmp!=null){
//             len++;
//             tmp=tmp.next;
//         }
//         int[] arr = new int[len];
//         len = 0;
//         tmp =head;
//         while(tmp!=null){
//             arr[len++] = tmp.val;
//             tmp = tmp.next;
//         }
//         int[] stack = new int[len];
//         int[] res = new int[len];
//         int index = -1;
//         for(int i=0;i<len;i++){
//             while(index!=-1 && arr[stack[index]]<arr[i]){
//                     res[stack[index--]] = arr[i];
//             }
            
//             stack[++index] = i;
//         }
//         return res;
//     }
