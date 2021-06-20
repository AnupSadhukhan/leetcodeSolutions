class NumArray {
    int[] st;
    int[] arr;
    public NumArray(int[] nums) {
        int height=(int)(Math.log(nums.length+1)/Math.log(2));
        int len=(int) (Math.floor(Math.pow(2,height)));
        len=2*len;
        st=new int[4*nums.length+1];
        arr=nums;
     
        constructTree(0,0,nums.length-1);
      
    }
    private int constructTree(int root,int ss,int se ){
        if(ss==se){
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
        
        
    }
    private int sumRangeUtil(int root,int ss,int se,int ql,int qr){
        if(qr<ss || ql>se) return 0;
        if(ql<=ss && qr>=se){
            return st[root];
        }
        int mid=(ss+se)/2;
        int sum=sumRangeUtil(2*root+1,ss,mid,ql,qr)+sumRangeUtil(2*root+2,mid+1,se,ql,qr);
        return sum;
    }
    public void update(int index, int val) {
         int diff=val-arr[index];
        arr[index]=val;
         updateUtil(index,diff,0,arr.length-1,0);
    }
    
    public int sumRange(int left, int right) {
        int x=sumRangeUtil(0,0,arr.length-1,left,right);
        return x;
        
    }
   
}
​
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
