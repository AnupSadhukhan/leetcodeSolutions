class Solution {
    int[][] dp;
   
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        dp = new int[n][m];
       
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],100000);
        }
       
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(mat[i][j]==0){
                    dp[i][j] = 0;
                }
                else{
                    if(isValid(i-1,j,n,m))
                        dp[i][j] = Math.min(dp[i][j],1+dp[i-1][j]);
                    if(isValid(i,j-1,n,m))
                         dp[i][j] = Math.min(dp[i][j],1+dp[i][j-1]);
                }
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j= m -1;j>=0;j--){
                
                if(mat[i][j]==0){
                    dp[i][j] = 0;
                }
                else{
                    if(isValid(i+1,j,n,m))
                        dp[i][j] = Math.min(dp[i][j],1+dp[i+1][j]);
                    if(isValid(i,j+1,n,m))
                         dp[i][j] = Math.min(dp[i][j],1+dp[i][j+1]);
                }
            }
        }
                
                       
        return dp;
    }
    private boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n) return false;
        if(col<0 || col>=m) return false;
        return true;
    }
}
