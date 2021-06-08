class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    makeIsland( i, j, grid);
                }
            }
        }
        return count;
    }
    public void makeIsland(int row,int col,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m) return;
        if(grid[row][col]!='1') return;
        grid[row][col]='2';
        makeIsland(row-1,col,grid);
        makeIsland(row,col+1,grid);
        makeIsland(row+1,col,grid);
        makeIsland(row,col-1,grid);
    }
}
