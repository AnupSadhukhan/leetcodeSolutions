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
   
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li=new ArrayList<Integer>();
        if(root==null) return li;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int offerC=0,pollC=0;
        queue.offer(root);
        pollC=++offerC;
        offerC=0;
        //li.add(root.val);
        TreeNode n=null;
        while(!queue.isEmpty()){
            if(pollC<=0){
                pollC=offerC;
                offerC=0;
            }
            n=queue.poll();
            pollC--;
            if(pollC<=0){
                li.add(n.val);
            }
            if(n.left!=null){
                queue.offer(n.left);
                offerC++;
            }
            if(n.right!=null){
                queue.offer(n.right);
                offerC++;
            }
            
        }
        
        return li;
    }
}
