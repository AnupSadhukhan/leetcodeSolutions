class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(!isRowWiseValid(board)) return false;
        if(!isColumnWiseValid(board)) return false;
        if(!isSubBoxesValid(board)) return false;
        return true;
    }
    private boolean isRowWiseValid(char[][] board){
        for(int row = 0; row < 9 ; row++){
            Set<Character> set = new HashSet<>();
            for(int col = 0 ; col < 9 ; col++){
                if(board[row][col]=='.') continue;
                if(set.contains(board[row][col])) return false;
                set.add(board[row][col]);
                
            }
        }
        return true;
    }
    private boolean isColumnWiseValid(char[][] board){
        for(int col = 0; col < 9 ; col++){
            Set<Character> set = new HashSet<>();
            for(int row = 0 ; row < 9 ; row++){
                if(board[row][col]=='.') continue;
                if(set.contains(board[row][col])) return false;
                set.add(board[row][col]);
                
            }
        }
        return true;
    }
    private boolean isSubBoxesValid(char[][] board){
       
        for(int row = 0; row<9;row+=3){
            for(int col = 0; col<9;col+=3){
                
                if(!is3x3BoxValid(board,row,col)) return false;
            }
