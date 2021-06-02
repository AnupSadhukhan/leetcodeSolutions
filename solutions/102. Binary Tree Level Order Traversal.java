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
    /* use queue, we will insert root first, while popping it
       will add it to list and other nodes depending on number of nodes
       at that level while popping we will add childrens of this node
       if available to queue, and perform same process.    
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        //result.add(list);
        while(!queue.isEmpty()){
            int size=queue.size();
            
            list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                   
                }
                if(node.right!=null){
                    queue.offer(node.right);
                   
                }
            }
            result.add(list);
            
        }
        return result;
    }
}
