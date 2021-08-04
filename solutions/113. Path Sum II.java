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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root==null) return result;
        pathSum(new ArrayList<>(),root,targetSum);
        return result;
    }
    private void pathSum(List<Integer> list,TreeNode root,int sum){
        if(root.left==null && root.right==null && sum==root.val){
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(root.left==null && root.right==null) return;
        list.add(root.val);
        if(root.left!=null){
           
            pathSum(list,root.left,sum-root.val);
        }
        if(root.right!=null){
             pathSum(list,root.right,sum-root.val);
        }
        list.remove(list.size()-1);
    }
    
}
