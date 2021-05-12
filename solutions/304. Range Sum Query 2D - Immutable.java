class NumMatrix {
    //calculate prefix sum for 2D matrix basis, when we need to return sum
    // of a rectangular, we will find value at row2,col2 then deduct 
    // rectangle (0,0) to (row1-1,col2) and (0,0) to (row2,col1-1)
    // as we have deducted row1-1,col1-1 rectangle twice, add it back 
    // and return the result    
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        // calculate prefix row
        for(int i=0;i<row;i++){
            for(int j=1;j<col;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        // on top that calculate prefix col( with row)
        for(int i=0;i<col;i++){
            for(int j=1;j<row;j++){
                matrix[j][i]+=matrix[j-1][i];
            }
        }
        prefix=matrix;
​
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=prefix[row2][col2];
        if(row1-1>=0) sum-=prefix[row1-1][col2];
        if(col1-1>=0) sum-=prefix[row2][col1-1];
        if(row1-1>=0 && col1-1>=0) sum+=prefix[row1-1][col1-1];
        return sum;
    }
}
​
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
