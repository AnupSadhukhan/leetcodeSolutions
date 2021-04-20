// Make a DFS call from current position to all four direction, if N>0 
// if N==0 and (i<0 || j<0 || i>=m || j>=n) return 1, else return 0
// if n is not 0 but (i<0 || j<0 || i>=m || j>=n), then return 1, as it is out of the grid
// we will use dp to stop state of every call to prevent same call again and again
// we will make 4 DFS call and store that in DP, at the end we will return the count or DP position value
class Solution {
    int[][][] dp;
    public int findPaths(int m, int n, int N, int i, int j) {
       dp=new int[N][m][n];
        for(int s=0;s<N;s++){
             for(int k=0;k<m;k++){
                Arrays.fill(dp[s][k],-1);
            }
        }
      
        return helper(m,n,N,i,j);
        
    }
    public int helper(int m, int n, int N, int i, int j) {
        if(N<=0 ){
            if(i<0 || j<0 || i>=m || j>=n) return 1;
            return 0;
        } 
        if(i<0 || j<0 || i>=m || j>=n) return 1;
        if(dp[N-1][i][j]!=-1) return dp[N-1][i][j];
        int count=0;
        count=(count+helper(m,n,N-1,i-1,j))%1000000007;
        count=(count+helper(m,n,N-1,i,j-1))%1000000007;
        count=(count+helper(m,n,N-1,i+1,j))%1000000007;
        count=(count+helper(m,n,N-1,i,j+1))%1000000007;
        
        dp[N-1][i][j]=count;
        return dp[N-1][i][j];
    }
}
