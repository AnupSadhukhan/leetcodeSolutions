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
​
// take a mid point , make that root, call recursive call to construct left sub tree
// with elements left side of mid element, and construct right sub tree, calling recursion 
// with elements right side of mid element, repeat the steps to construct the tree
// we will find out mid point using slow and fast pointer 
// O(nlogn) time complexity
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return constructBST(head,null);
        
    }
    public TreeNode constructBST(ListNode head,ListNode trail){
        if(head==trail) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=trail && fast.next!=trail){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=constructBST(head,slow);
        root.right=constructBST(slow.next,trail);
        return root;
    }
}
