class Solution {
    // DFS and Memorization
    // we will make a sum, if sum==target and we are done with the dice, return 1, else 0
    // we are using DP with index and target as states, if data is present we will simply return
    // while checking different face combination, we will check if left out sum is 
    // greater than or equal to dice face value or not, if yes, we proceed, else break; 
    // set the count value in dp and return;
    int[][] dp;
    int mod=1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        dp=new int[d][target];
        for(int i=0;i<d;i++) Arrays.fill(dp[i],-1);
        return helper(0,target,0,f,d);
    }
    public int helper(int sum,int target,int index,int f,int d){
        if(sum==target && index==d) return 1;
        if(sum>=target || index>=d) return 0;
        if(dp[index][target-sum-1]!=-1) return dp[index][target-sum-1];
        
        
        int count=0;
        for(int i=1;i<=f;i++){
            if(target-sum>=i)
            count=(count+helper(sum+i,target,index+1,f,d))%mod;
            else break;
        }
        dp[index][target-sum-1]=count%mod;
        return dp[index][target-sum-1];
        
    }
}
