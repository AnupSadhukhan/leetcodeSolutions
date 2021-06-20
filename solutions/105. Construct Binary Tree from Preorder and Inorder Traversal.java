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
    /* find root from preorder traversal, i.e. all roots are available from starting index,
       then find that root position in inorder traversal, after that recur for left sub tree 
       and right subtree with start to root position-1 in inorder and root postion + 1 to end
       
     */
    /* 5ms
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          
        return construct(0,0,inorder.length-1,preorder,inorder);
    }
    private TreeNode construct(int rootIndex,int left,int right,int[] preorder,int[] inorder){
        if(rootIndex>=preorder.length || left>right) return null;
        int pos=getPos(preorder[rootIndex],left,right,inorder);
        if(pos==-1) return null;
        TreeNode node=new TreeNode(inorder[pos]);
        node.left=construct(rootIndex+1,left,pos-1,preorder,inorder);
        node.right=construct(rootIndex+(pos-left)+1,pos+1,right,preorder,inorder);
        return node;
    }
    private int getPos(int root,int left,int right,int[] inorder){
        if(left==right) return left;
        for(int i=left;i<=right;i++){
            if(inorder[i]==root) return i;
        }
        return -1;
    }*/
    /* 1ms
    static int pIndex=0;
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        if((preorder.length!=inorder.length) || (preorder.length==0 || inorder.length==0)) return null;
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        pIndex=0;
        //System.out.println("pIndex : "+pIndex);
       return build(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] pre,int[] in,int start, int end){
        //System.out.println("pIndex : "+pIndex+" data : "+pre[pIndex]+" start : "+start+" end : "+end);
        if(start>end ) return null;
        TreeNode node=new TreeNode(pre[pIndex]);
        if(start==end) {
            pIndex++;
            return node;
