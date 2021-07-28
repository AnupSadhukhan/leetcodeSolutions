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
    // my sol  - 21ms
   /* public int[] nextLargerNodes(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        //System.out.println("loop - 1 end");
        int[] res = new int[len];
        head = reverse(head);
        //System.out.println("loop - reverse end");
        tmp = head;
        Stack<Integer> stack = new Stack<>();
        int i=len-1;
        while(tmp!=null){
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
//     public int[] nextLargerNodes(ListNode head) {
//         int len=0;
//         ListNode tmp = head;
//         while(tmp!=null){
//             len++;
//             tmp=tmp.next;
//         }
//         int[] arr = new int[len];
//         len = 0;
//         tmp =head;
//         while(tmp!=null){
//             arr[len++] = tmp.val;
//             tmp = tmp.next;
//         }
//         int[] stack = new int[len];
//         int[] res = new int[len];
//         int index = -1;
//         for(int i=0;i<len;i++){
//             while(index!=-1 && arr[stack[index]]<arr[i]){
//                     res[stack[index--]] = arr[i];
//             }
            
//             stack[++index] = i;
//         }
//         return res;
//     }
    // same code as above - 3ms
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        for(ListNode i=head;i!=null;i=i.next){
            ++n;
        }
        int[] nums = new int[n];
        n = 0;
        while(head!=null){
            nums[n++]=head.val;
            head=head.next;
        }
        int[] stack = new int[n];
        int[] ans = new int[n];
        int index = -1;
        for(int i=0;i<n;++i){
            if(index!=-1 && nums[stack[index]]<nums[i]){
                 while(index!=-1 && nums[stack[index]]<nums[i]){
                ans[stack[index--]]=nums[i];
                }
            }
            stack[++index]=i;
        }
        return ans;
    }
}
