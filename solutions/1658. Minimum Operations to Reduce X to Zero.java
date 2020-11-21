class Solution {
    public int minOperations(int[] nums, int x) {
      int sum=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            map.put(sum,i);
        }
        if(x>sum) return -1;
        if(sum==x) return n;
        int longest=0;
        int val=0;
        sum-=x;
        for(int i=0;i<n;i++){
            val+=nums[i];
            Integer idx=map.get(val-sum);
            if(idx!=null ){
                if(val-sum==0){
                    longest=Math.max(longest,i+1);
                }
                else{
                    longest=Math.max(longest,i-idx);
                }
            }
        }
        return longest==0?-1 : n-longest;
       
    }
}
