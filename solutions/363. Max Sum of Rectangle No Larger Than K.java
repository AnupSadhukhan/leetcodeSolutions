class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]+= (i-1>=0?matrix[i-1][j]:0) + (j-1>=0?matrix[i][j-1]:0) - (i-1>=0 && j-1>=0?matrix[i-1][j-1]:0);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxSum=Math.max(maxSum,findMax(matrix,i,j,k));
                if(maxSum==k) return k;
            }
        }
        
        return maxSum;
        
    }
    private int findMax(int[][] matrix,int row,int col,int k){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                sum=matrix[row][col]-(i-1>=0 ? matrix[i-1][col] : 0 ) - (j-1>=0 ? matrix[row][j-1] : 0 ) + (i-1>=0 && j-1>=0? matrix[i-1][j-1] : 0 );
                if(sum<k){
                    maxSum=Math.max(maxSum,sum);
                }
                if(sum==k) return k;
            }
        }
        return maxSum;
    }
}
