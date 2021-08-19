class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean setRowCol = false;
        
        Set<Integer> rowWithZero = new HashSet<>();
        Set<Integer> colWithZero = new HashSet<>();
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]==0){
                    rowWithZero.add(i);
                    colWithZero.add(j);
                }
            }
        }
        for(int row : rowWithZero){
            int col =0;
            while(col<m){
                matrix[row][col] = 0;
                col++;
            }
        }
        for(int col :  colWithZero){
            int row = 0;
            while(row<n){
                matrix[row][col] = 0;
                row++;
            }
        }
      
    }
    
}
