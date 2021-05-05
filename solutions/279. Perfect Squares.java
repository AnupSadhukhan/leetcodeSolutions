class Solution {
    int[] sq;
    int[] dp;
    public int numSquares(int n) {
        sq=new int[100];
        for(int i=1;i<=100;i++){
            sq[i-1]=i*i;
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
    public int helper(int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int count=Integer.MAX_VALUE;
        for(int i=0;i<100;i++){
            if(sq[i]<=n){
                count=Math.min(count,1+helper(n-sq[i]));
            }
            else break;
        }
        dp[n]=count;
        return dp[n];
    }
}
