class NumArray {
    int[] st;
    int[] arr;
    public NumArray(int[] nums) {
        int height=(int)(Math.log(nums.length+1)/Math.log(2));
        int len=(int) (Math.floor(Math.pow(2,height)));
        len=2*len;
        st=new int[4*nums.length+1];
        arr=nums;
       // System.out.println(" len "+nums.length);
        constructTree(0,0,nums.length-1);
        //print("construct - ");
    }
    private int constructTree(int root,int ss,int se ){
        if(ss==se){
          //System.out.println(" root "+root+" "+ss);;
​
            st[root]=arr[ss];
            return st[root];
        }
        int mid=(ss+se)/2;
        st[root]=constructTree(2*root+1,ss,mid) + constructTree(2*root+2,mid+1,se);
        return st[root];
    }
    private void updateUtil(int index,int diff,int ss,int se,int root){
        if(index>se || index<ss) return;
       
        st[root]+=diff;
        if(ss!=se){
            int mid=(ss+se)/2;
            updateUtil(index,diff,ss,mid,2*root+1);
            updateUtil(index,diff,mid+1,se,2*root+2);
        }
        
