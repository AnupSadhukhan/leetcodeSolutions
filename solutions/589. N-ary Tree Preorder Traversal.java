/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
​
    public Node() {}
​
    public Node(int _val) {
        val = _val;
    }
​
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// if root is null return res list without adding anything
// if root is not null, add its value to re list
// check whether it has children or not, if it has children then
// one by one take them and call recursive function
class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null) return res;
        res.add(root.val);
        if(root.children!=null && root.children.size()>0){
            for(Node node : root.children){
                preorder(node);
            }
        }
        return res;
    }
}
