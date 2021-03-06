class Solution {
    class Tile{
        int x;
        int y;
        int timeElapsed;
        Tile(int x,int y,int timeElapsed){
            this.x=x;
            this.y=y;
            this.timeElapsed=timeElapsed;
        }
    }
    public int swimInWater(int[][] grid) {
        int time=0;
        boolean[] vis=new boolean[50*50];
        PriorityQueue<Tile> queue=new PriorityQueue<>((a,b)->a.timeElapsed-b.timeElapsed);
        vis[0]=true;
        int n=grid.length;
        queue.add(new Tile(0,0,grid[0][0]));
        int[][] dirs=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            Tile tile=queue.poll();
            time=Math.max(time,tile.timeElapsed);
            
            if(tile.x==n-1 && tile.y==n-1){
                break;
            }
            for(int[] dir : dirs){
                int x=tile.x+dir[0];
                int y=tile.y+dir[1];
             
                if(x<0 || x>=n || y<0 || y>=n || vis[(x*n)+y]) continue;
                vis[(x*n)+y]=true;
                queue.add(new Tile(x,y,grid[x][y]));
            }
            
        }
        return time;
    }
}
/*
class Solution {
    int dir[] = new int[]{0,1,0,-1,0};
    public int swimInWater(int[][] grid) {
      int length = grid.length;
      int low = 0;
      int high = length*length;
      while(low < high)
      {
        
        int mid = low + (high-low)/2;
        int visited[][] = new int[grid.length][grid[0].length];
        if(dfs(grid, 0, 0, visited, mid))
        {
          high = mid;
        }
        else{
          low = mid+1;
        }
      }
     return high;
    }
  
  
   public boolean  dfs(int[][] grid, int i, int j, int visited[][], int time)
   {
     if(i == grid.length-1 && j== grid[0].length-1)
     {
       return true;
     }
     if(grid[i][j] > time) return false;
     visited[i][j] = 1;
     boolean res = false;
     for(int d = 0; d < dir.length -1 ; d++)
     {
       int r = i + dir[d];
       int c = j + dir[d + 1];
       if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] == 1 || time < grid[r][c]) continue;
       if(dfs(grid,  r, c, visited, time)) return true;
      }
     return res;
   }
}
*/
