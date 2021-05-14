class Solution {
    public int longestPalindromeSubseq(String s) {
        /* O(n^2) 67ms
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        String reverseStr=new StringBuilder(s).reverse().toString();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==reverseStr.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n]; */
        
        // O(n^2) 24ms
       /* int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        char[] chs=s.toCharArray();
        for(int gap=2;gap<=n;gap++){
            for(int i=0;i+gap-1<n;i++){
                int j=i+gap-1;
                if(chs[i]==chs[j]){
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][n-1]; */
        // O(n^2) 26ms (Top down with memo)
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s.toCharArray(),0,s.length()-1,dp);
    }
    public int helper(char[] chs,int start,int end,int[][] dp){
        if(start>end) return 0;
        if(start==end) return 1;
        if(dp[start][end]!=-1) return dp[start][end];
        if(chs[start]==chs[end]){
            dp[start][end]=2+helper(chs,start+1,end-1,dp);
        }
        else{
            dp[start][end]=Math.max(helper(chs,start+1,end,dp),helper(chs,start,end-1,dp));
        }
        return dp[start][end];
    }
}
