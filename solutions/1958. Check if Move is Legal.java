class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if(board[rMove][cMove]!='.') return false;
        board[rMove][cMove] = color;
        if(leftUpperDiagonal(board,rMove,cMove,color)) return true;
        
        if(rightUpperDiagonal(board,rMove,cMove,color)) return true;
        
        if(leftDownDiagonal(board,rMove,cMove,color)) return true;
        
        if(rightDownDiagonal(board,rMove,cMove,color)) return true;
        
        if(upperVertical(board,rMove,cMove,color)) return true;
        
        if(downVertical(board,rMove,cMove,color)) return true;
        
        if(leftHorizontal(board,rMove,cMove,color)) return true;
        
        if(rightHorizontal(board,rMove,cMove,color)) return true;
        
        return false;
        
    }
    private boolean leftUpperDiagonal(char[][] board,int row,int col, char color){
        int count = 2;
        row--;
        col--;
        while(row>0 && col>0){
            if(count>=3 && board[row][col]==color) return true;
            if(board[row][col]==color || board[row][col]=='.' ) return false;
            count++;
            row--;
            col--;
        }
        if(count<3) return false;
        if(board[row][col]!=color) return false;
        return true;
        
    }
    private boolean rightUpperDiagonal(char[][] board,int row,int col, char color){
        int count = 2;
        row--;
        col++;
        while(row>0 && col<8-1){
             if(count>=3 && board[row][col]==color) return true;
            if(board[row][col]==color || board[row][col]=='.' ) return false;
            count++;
            row--;
            col++;
        }
        if(count<3) return false;
        if(board[row][col]!=color) return false;
