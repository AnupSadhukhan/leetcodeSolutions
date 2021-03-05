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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<Double> li=new ArrayList<Double>();
        //li.add((double)root.val);
        q.offer(root);
       
        while(!q.isEmpty()){
            int size=q.size();
            long totalVal=0;
            
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                totalVal+=node.val;
                if(node.left!=null){
                    
                    
                    q.offer(node.left);
                }
