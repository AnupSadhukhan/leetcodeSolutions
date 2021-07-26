 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
       
        
        return buildTree(nums,nums.length-1,0);
    }
    public TreeNode buildTree(int[] nums,int right,int left){
        if(right<left) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=buildTree(nums,mid-1,left);
        root.right=buildTree(nums,right,mid+1);
        
        return root;
    }
    /*
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return constructTree(nums,0,nums.length-1);
    }
    public TreeNode constructTree(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=constructTree(nums,left,mid-1);
        root.right=constructTree(nums,mid+1,right);
        return root;
    }
    */
}
