class Solution {
    //Prerequisite: 62. Unique Paths
    // concept is same, here we have to introduce and extra codition while traversing
    // or doing DFS call, if next place is not occupied by obstracle then 
    // we can move ahead and do the counting process. else we will not make DFS call.
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1)return 0;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return count(0,0,m-1,n-1,obstacleGrid);
    }
     
   
    public int count(int x,int y,int m,int n,int[][] grid){
        if(dp[x][y]!=-1) return dp[x][y];
        if(x==m && y==n) return 1;
        int count=0;
        if(x+1<=m && grid[x+1][y]==0) count+=count(x+1,y,m,n,grid);
        if(y+1<=n && grid[x][y+1]==0) count+=count(x,y+1,m,n,grid);
        dp[x][y]=count;
        return dp[x][y];
    }
}
