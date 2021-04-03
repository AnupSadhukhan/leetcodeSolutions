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
        if(i==cost.length) return 0;
        if(dp[i]>0) return dp[i];
       dp[i]=cost[i]+Math.min(minCost(i+1,cost,dp),minCost(i+2,cost,dp));
           return dp[i];
    }
}
