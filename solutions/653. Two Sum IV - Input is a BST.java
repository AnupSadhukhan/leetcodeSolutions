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
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        set = new HashSet<>();
        return findTargetUtil(root,k);
    }
    private boolean findTargetUtil(TreeNode root,int k){
        if(root==null) return false;
        int newTarget = k-root.val;
        if(set.contains(newTarget)) return true;
        set.add(root.val);
        return findTargetUtil(root.left,k) || findTargetUtil(root.right,k);
    }
}
