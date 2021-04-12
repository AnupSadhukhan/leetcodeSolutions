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
