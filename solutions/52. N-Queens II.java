class Solution {
    boolean[][] chessBoard;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        chessBoard=new boolean[n][n];
        helper(0,n);
        return count;
    }
    int count=0;
    public void helper(int row,int n){
        if(row==n){
            count++;
        }
        for(int col=0;col<n;col++){
            if(!upperStraight(row-1,col)) continue;
            if(!upperLeftDiagonal(row-1,col-1)) continue;
            if(!upperRightDiagonal(row-1,col+1,n)) continue;
            chessBoard[row][col]=true;
            helper(row+1,n);
            chessBoard[row][col]=false;
        }
    }
    public boolean upperStraight(int row,int col){
        while(row>=0){
            if(chessBoard[row][col]) return false;
            row--;
        }
        return true;
    }
    public boolean upperLeftDiagonal(int row,int col){
        while(row>=0 && col>=0){
             if(chessBoard[row][col]) return false;
            row--;
            col--;
        }
        return true;
    }
    public boolean upperRightDiagonal(int row,int col,int n){
        while(row>=0 && col<n){
             if(chessBoard[row][col]) return false;
            row--;
            col++;
        }
        return true;
    }
}
