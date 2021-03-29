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
    int idx=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> li=new ArrayList<Integer>();
        if(root==null) {
            li.add(-1);
            return li;
        }
        
        if(!flip(root,voyage,li)){
            li=new ArrayList<>();
            li.add(-1);
            return li;
        }
        return li;
        
        
