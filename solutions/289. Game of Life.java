class Solution {
    private final int willRevive=2;
    private final int willDie=3;
    private int[][] neighbors={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0){
                   
                    if(CountAliveNeighbors(i,j,board)==3)
                     board[i][j]=willRevive;
                   
                }
                else{
                    int count = CountAliveNeighbors(i,j,board);
                    if(count<2 || count>3) 
                        board[i][j]=willDie;
                  
                }
            }
        }
        
        // update board
        for(int i=0;i<n ;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==willRevive){
                    board[i][j]=1;
                }
                else if(board[i][j]==willDie){
                    board[i][j]=0;
                }
            }
        }
        
    }
    private int CountAliveNeighbors(int row,int col,int[][] board){
        int n=board.length;
        int m=board[0].length;
        int aliveNeighbors=0;
        
        for(int[] neighbor : neighbors ){
            int x = row + neighbor[0];
            int y = col + neighbor[1];
            if(x>=0 && y>=0 && x<n && y<m && (board[x][y]==1 || board[x][y]==willDie))
                aliveNeighbors++;
            
        }
        return aliveNeighbors;
        
        
    }
    
}
