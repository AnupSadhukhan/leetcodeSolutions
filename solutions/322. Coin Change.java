class Solution {
    public int coinChange(int[] coins, int amount) {
       int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=0;
            for(int j=1;j<amount+1;j++){
                if(i==0) dp[i][j]=Integer.MAX_VALUE;
                else if(coins[i-1]>j)dp[i][j]=dp[i-1][j];
                else if(dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount]==Integer.MAX_VALUE) return -1;
        return dp[coins.length][amount];
        
    }
}
