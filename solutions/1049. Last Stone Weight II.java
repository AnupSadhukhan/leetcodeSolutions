class Solution {
    // we have to split array into to half such that diff is minimum, if diff is minimum
    // last left stone will be always minimum, 
    // so we will sum up all the weight of the stones and will try to make a sum of sum/2
    // using elements. while doing so will try to find max sum, in case there is no sum 
    // possible with elements for sum/2. we will retun sum-2*max;
    // e.g sum=12, we get max=6 then return 0, if we get 5 return 12 - 2*5=10
    // e.g. sum=13, target=6, we get 6, then return 13-2*6=1 ...
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int x : stones) sum+=x;
        int target=(sum/2)+1;
        boolean[] dp=new boolean[target];
        dp[0]=true;
        int max=0;
        for(int i=0;i<stones.length;i++){
            boolean[] dp1=dp.clone();
            for(int j=stones[i];j<=sum/2;j++){
                if(dp[j-stones[i]]){
                   
                    dp1[j]=true;
                    max=Math.max(max,j);
                  
                }
                if(dp1[sum/2]){
                   return sum-2*(sum/2);
                }
            }
            /*
            boolean[] dp1=new boolean[target];
            for(int j=0;j<=sum/2;j++){
                if(dp[j]|| (j-stones[i]>=0 && dp[j-stones[i]])){
                   
                    dp1[j]=true;
                    max=Math.max(max,j);
                  
                }
                if(dp1[sum/2]){
                   return sum-2*(sum/2);
                }
            }
            */
            
            dp=dp1;
        }
        return sum-2*max;
    }
    // using recursion, exponential time complexity
    /*public int lastStoneWeightII(int[] stones) {
      return smash(stones,0,0);
    }
    public int smash(int[] stones,int index,int taken){
        if(index>=stones.length) return Integer.MAX_VALUE;
        if(index==stones.length-1) return stones[stones.length-1];
        int min=Integer.MAX_VALUE;
        for(int i=index+1;i<stones.length;i++){
            int val=stones[i];
            stones[i]=Math.abs(stones[i]-stones[index]);
            min=Math.min(min,smash(stones,index+1,0));
            stones[i]=val;
        }
        
        return min;
    }*/
    
}
