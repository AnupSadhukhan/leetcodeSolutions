class Solution {
    class Node{
        int val;
        int index;
        Node(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] res=new int[nums.length];
        Node[] nodes=new Node[nums.length];
        for(int i=0;i<nums.length;i++){
            nodes[i]=new Node(nums[i],i);
        }
        helper(nodes,0,nums.length-1,res);
       List<Integer> list=new ArrayList<>();
        int i=0;
        for(int elm :  res){
            list.add(elm);
            i++;
        }
        return list;
    }
    public void helper(Node[] nums,int start,int end,int[] res){
        if(end>start){
            int mid=(start+end)/2;
           
            helper(nums,mid+1,end,res);
            helper(nums,start,mid,res);
            mergeAndCountInversion(nums,start,mid,end,res);
        }
       
    }
    public void mergeAndCountInversion(Node[] nums,int start,int mid,int end,int[] res){
      
        List<Node> list=new ArrayList<>();
        
        int i=start,j=mid+1,k=start;
        while(i<=mid && j<=end){
            if(nums[i].val>nums[j].val){
               
                int count=end-j+1;
                res[nums[i].index]+=count;
