class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> li=new ArrayList<>();
        int[][] dp=new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            li.add(get(rowIndex,i,dp));
        }
        return li;
    }
    public int get(int row,int col,int[][] dp){
        if(col==0 || row==col){
            
            return 1;
        }
        if(dp[row][col]!=0) return dp[row][col];
        return dp[row][col]=get(row-1,col-1,dp)+get(row-1,col,dp);
    }
}
