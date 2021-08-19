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
    long max;
    public int maxProduct(TreeNode root) {
        if(root==null) return 0;
        long totalSum = sumUp(root);
        max = 0;
        maxProductUtil(root,totalSum);
        return (int)(max % (int)(1e9 + 7));
    }
    private long sumUp(TreeNode root){
        if(root==null) return 0;
        root.val+= sumUp(root.left) + sumUp(root.right);
        return root.val;
    }
    private void maxProductUtil(TreeNode root,long totalSum){
        if(root==null) return;
        
        maxProductUtil(root.left,totalSum);
        maxProductUtil(root.right,totalSum);
       
        max = Math.max(max,root.val*(totalSum-root.val));
      
        
    }
}
