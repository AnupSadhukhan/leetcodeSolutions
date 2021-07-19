/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
​
class Solution {
   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!= null) return root;
        if(left==null && right!=null) return right;
        if(right==null && left!=null) return left;
        return null;
    }
    */
    // 3ms  using BST property
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = new TreeNode();
        if (p.val > q.val) {
            ans = getLCA(root, q.val, p.val);
        } else {
            ans = getLCA(root, p.val, q.val);
        }
        return ans;
    }
    
    private TreeNode getLCA(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }
        
        if (p <= node.val && node.val <= q) {
            return node;
        } else if (node.val > q) {
            return getLCA(node.left, p, q);
        } else if (node.val < q) {
            return getLCA(node.right, p, q);
        }
        
        return null;
    }
    
}
