class Solution {
    /* //solution 1
    Map<Pair<Integer,Integer>,Integer> map=new HashMap<>(); 
    public int findTargetSumWays(int[] nums, int S) {
      
        return countTargetSum(nums,0,S);
    }
    public int countTargetSum(int[] num,int idx,int s){
        Pair<Integer,Integer> pair=new Pair<>(idx,s);
        if(map.containsKey(pair)) return map.get(pair);
        
        if(idx==num.length && s==0) return 1;
        else if(idx==num.length && s!=0) return 0;
      
       
        map.put(pair,countTargetSum(num,idx+1,s+num[idx])+countTargetSum(num,idx+1,s-num[idx]));
        return map.get(pair);
    }
    */
    public int findTargetSumWays(int[] nums, int s) {
      int sum=0;
      for(int n : nums) sum+=n;
      if(s<-sum || s>sum) return 0;
      int[] dp=new int[2*sum+1];
      dp[sum]=1;
      for(int i=0;i<nums.length;i++){
          int[] dp1=new int[2*sum+1];
          for(int  j=0;j<2*sum+1;j++){
              if(dp[j]!=0){
                  dp1[j+nums[i]]+=dp[j];
                  dp1[j-nums[i]]+=dp[j];
              }
          }
          dp=dp1;
      }
        return dp[sum+s];
        
    }
}
