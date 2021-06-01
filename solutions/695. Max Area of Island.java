class Solution {
    int[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        vis=new int[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && vis[i][j]==0){
                    max=Math.max(max,DFS(i,j,grid));
                }
                    
            }
        }
        return max;
    }
    public int DFS(int row,int col,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row>=n || col>=m || row<0 || col<0 || grid[row][col]==0) return 0;
        if( vis[row][col]!=0) return 0;
        int max=0;
        
        vis[row][col]=1;
        // up
        if(row-1>=0)
            max+=DFS(row-1,col,grid);
        //rigth
        if(col+1<m)
            max+= DFS(row,col+1,grid);
        //down
        if(row+1<n)
            max+=DFS(row+1,col,grid);
        //left
        if(col-1>=0)
            max+= DFS(row,col-1,grid);
