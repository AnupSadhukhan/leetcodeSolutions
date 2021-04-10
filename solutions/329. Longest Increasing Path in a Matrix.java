class Solution {
    /*
     Intuition : as we have to travese through the matrix based on the condition. We can
     take use of DFS here. in dfs call we will traverse if data in next block(left,right,up,down)
     is greater than current one. While traversiong we will count length also and save the value in
     a dp so that next time when we call the same block again, we will get it quickly withiut travesing again
     so using memorization and DFS we can achieve a solution.
    */
    //int[] dir=new int[]{-1,0,0,1,1,0,0,-1};
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean[][] vis=new boolean[n][m];
        int[][] dp=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=vis[i][j]?dp[i][j]:dfs(i,j,dp,vis,matrix,n,m);
                // we have added one bcz, it current block will contribute to length as well
                max=Math.max(max,1+dp[i][j]);
               
            }
           
        }
        return max;
    }
    public int dfs(int i,int j,int[][] dp,boolean[][] vis,int[][] mat,int n,int m){
        if(vis[i][j]) return dp[i][j];
        vis[i][j]=true;
        int len=0;
        if(i-1>=0 && mat[i-1][j]>mat[i][j]){
            len=Math.max(len,1+dfs(i-1,j,dp,vis,mat,n,m));
        }
        if(j+1<m && mat[i][j+1]>mat[i][j])   len=Math.max(len,1+dfs(i,j+1,dp,vis,mat,n,m));
        if(i+1<n && mat[i+1][j]>mat[i][j]) len=Math.max(len,1+dfs(i+1,j,dp,vis,mat,n,m));
        if(j-1>=0 && mat[i][j-1]>mat[i][j]) len=Math.max(len,1+dfs(i,j-1,dp,vis,mat,n,m));
        dp[i][j]=len;
        return len;
       
    }
}
