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
    
    
    public int goodNodes(TreeNode root) {
        
        
        return checkNode(root,Integer.MIN_VALUE);
    }
    private int checkNode(TreeNode root,int val){
        if(root==null) return 0;
        int count = 0;
        if(root.val>=val){
            val = root.val;
            count = 1;
        }
        return count+checkNode(root.left,val)+checkNode(root.right,val);
    }
}
