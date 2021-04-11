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
    // as we have to return deepest leaves sum, we can use level order 
    // traversal, to go level by level and calculating sum at each level
    // whenever we are going to new level we are reseting sum to 0
    // and calculating sum for that level, if that level is the last level
    // we return the sum else, we continue the process.
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> q=new LinkedList<>();
        int sum=0;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            
        }
        return sum;
    }
}
