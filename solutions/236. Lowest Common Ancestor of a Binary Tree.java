/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode LCA=findLCA(root,p,q);
        if(LCA==null) return root;
        return LCA;
    }
    private TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
         if(root.val==p.val) return root;
         if(root.val==q.val) return root;
         TreeNode left=findLCA(root.left,p,q);
         TreeNode right=findLCA(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
        
    }
}
