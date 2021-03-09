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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null) return null;
        if(d==2){
            TreeNode node=new TreeNode(v,root.left,null);
            TreeNode node1=new TreeNode(v,null,root.right);
            root.left=node;
            root.right=node1;
            return root;
        }
        if(d==1){
            TreeNode node=new TreeNode(v,root,null);
            return node;
        }
        
        root.left=addOneRow(root.left,v,d-1);
        root.right= addOneRow(root.right,v,d-1);
        return root;
    }
}
