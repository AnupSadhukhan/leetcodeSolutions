class Solution {
    //DFS + memorization
    int[][] dirs={{1},{0,2},{0,1,3,4},{2,4},{0}};
    int[][] dp;
    public int countVowelPermutation(int n) {
       int count=0;
        dp=new int[n][5];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<5;i++){
            count=(count+count(n-1,i))%1000000007;
        }
        return count;
    }
    public int count(int n,int i){
        if(n==0) return 1;
        if(dp[n-1][i]!=-1) return dp[n-1][i];
        int count=0;
        for(int x:dirs[i]){
            count=(count+count(n-1,x))%1000000007;
        }
        dp[n-1][i]=count;
        return dp[n-1][i];
    }
}
