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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        
        
       return checkPath(head,root,false);   
    }
    private boolean checkPath(ListNode head, TreeNode root, boolean isCheckingStarted){
        if(head==null) return true;
        if(root==null) return false;
        if(isCheckingStarted){
            if(head.val!=root.val) return false;
            if(checkPath(head.next,root.left,isCheckingStarted) || checkPath(head.next,root.right,isCheckingStarted)) return true;
        }
        else{
            if(head.val==root.val){
                if(checkPath(head.next,root.left,true) || checkPath(head.next,root.right,true)) return true;
            }
            
                if(checkPath(head,root.left,false) || checkPath(head,root.right,false)) return true;
            
        }
        return false;
    }
}
