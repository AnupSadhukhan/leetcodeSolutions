class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row==0 && col==0) return 0;
        int[][] dp=new int[2][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 ){
                    if(j==0)
                        dp[i][j]=grid[i][j];
                    else
                     dp[i][j]=grid[i][j]+dp[i][j-1];
                }
                else{
                    if(j==0)
                     dp[i%2][j]=dp[(i-1)%2][j]+grid[i][j];
                    else 
                        dp[i%2][j]=grid[i][j]+Math.min(dp[(i-1)%2][j],dp[i%2][j-1]);
                }
                    
            }
        }
        return dp[(row-1)%2][col-1];
    }
}
