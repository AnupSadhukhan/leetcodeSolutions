class Solution {
    List<List<String>> res;
    int[][] chessBoard;
    public List<List<String>> solveNQueens(int n) {
        chessBoard=new int[n][n];
        res=new ArrayList<>();
        helper(0,n,new ArrayList<>());
        return res;
    }
    
    public void helper(int row,int n,List<String> list){
        if(row==n && list.size()==n){
            List<String> ans=new ArrayList<>();
            for(String s : list){
                ans.add(s);
            }
            res.add(ans);
            return;
        }
        char[] chs=new char[n];
        Arrays.fill(chs,'.');
        for(int col=0;col<n;col++){
            if(!upperStraight(row-1,col)) continue;
            if(!upperLeftDiagonal(row-1,col-1)) continue;
            if(!upperRightDiagonal(row-1,col+1,n)) continue;
            //placing queen
            chessBoard[row][col]=1;
            chs[col]='Q';
            String s=new String(chs);
            list.add(s);
            helper(row+1,n,list);
            //removing queen
            list.remove(list.size()-1);
            chs[col]='.';
            chessBoard[row][col]=0;
        }
    }
    public boolean upperStraight(int row,int col){
        while(row>=0){
            if(chessBoard[row][col]==1) return false;
            row--;
        }
        return true;
    }
    public boolean upperLeftDiagonal(int row,int col){
        while(row>=0 && col>=0){
            if(chessBoard[row][col]==1) return false;
            row--;
            col--;
        }
        return true;
    }
    public boolean upperRightDiagonal(int row,int col,int n){
        while(row>=0 && col<n){
            if(chessBoard[row][col]==1) return false;
            row--;
            col++;
        }
        return true;
