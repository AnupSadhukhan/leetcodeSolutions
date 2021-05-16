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
    private int NOT_MONITORED=0;
    private int MONITORED_NOCAM=1;
    private int MONITORED_WITHCAM=2;
    int camera=0;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int top=dfs(root);
        return camera+(top==NOT_MONITORED?1:0);
    }
    public int dfs(TreeNode root){
        if(root==null) return MONITORED_NOCAM;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==NOT_MONITORED || right==NOT_MONITORED){
            camera++;
            return MONITORED_WITHCAM;
        }
        else if(left==MONITORED_NOCAM && right==MONITORED_NOCAM){
            return NOT_MONITORED;
        }
        else return MONITORED_NOCAM;
    }
}
