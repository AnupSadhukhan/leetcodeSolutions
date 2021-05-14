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
    //O(1) space
    TreeNode pointer=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(pointer==null) pointer=root;
        TreeNode rightSide=root.right;
        if(root.left!=null){
            pointer.right=root.left;
            root.left=null;
            pointer=pointer.right;
            flatten(pointer);
            
        }
        if(rightSide!=null){
             pointer.right=rightSide;
            pointer=pointer.right;
            flatten(pointer);
        }
       
    }
   
}
