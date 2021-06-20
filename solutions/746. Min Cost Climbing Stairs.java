class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0) return 0;
        /*if(cost.length==1)return cost[0];
        if(cost.length==2) return Math.min(cost[0],cost[1]);
        int[] dp=new int[cost.length+1];
        dp[0]=cost[0];
        for(int i=1;i<=cost.length;i++){
            int c=0;
            if(i<cost.length)c=cost[i];
            dp[i]=c+Math.min(dp[i-1],(i-2>=0?dp[i-2]:(int)1e7));
            
        }
     
        int[] dp1=new int[cost.length+1];
        dp1[1]=cost[1];
        for(int i=2;i<=cost.length;i++){
              int c=0;
            if(i<cost.length)c=cost[i];
            dp1[i]=c+Math.min(dp1[i-1],(i-2>=1?dp1[i-2]:(int)1e7));
            
        }
       
        return Math.min(dp[cost.length],dp1[cost.length]);*/
        
        if(cost.length==1)return cost[0];
        if(cost.length==2) return Math.min(cost[0],cost[1]);
       
      
        int cost1=cost[0],cost2=0;
        int c=0,c1=0,c2=0;
        for(int i=0;i<=cost.length;i++){
            c=0;
            if(i<cost.length)c=cost[i];
            c1=c+Math.min(cost1,cost2);
            cost2=cost1;
            cost1=c1;
            
        }
     //System.out.println(c1);
       
       cost1=cost[1];
        cost2=0;
        for(int i=1;i<=cost.length;i++){
             c=0;
            if(i<cost.length)c=cost[i];
            c2=c+Math.min(cost1,cost2);
            cost2=cost1;
            cost1=c2;
            
        }
      // System.out.println(c2);
        return Math.min(c1,c2);
        
        //int[] dp=new int[cost.length];
        //return Math.min(minCost(0,cost,dp),minCost(1,cost,dp));
    }
    public int minCost(int i,int[] cost,int[] dp){
        if(i>cost.length) return (int) 1e7;
