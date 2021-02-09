            sum=left;
        }
        
        return sum;
        
    }
    */
    /* another approch */
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        visit(root);
        return root;
    }
    
    private void visit(TreeNode node){
        if(node == null) return;
        visit(node.right);
        sum = sum + node.val;
        node.val = sum;
        visit(node.left);
    }
    //ends
    /* another memory saving approch
     int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        root.val+=sum;
        sum=root.val;
        convertBST(root.left);
        return root;
    }
    */
}
