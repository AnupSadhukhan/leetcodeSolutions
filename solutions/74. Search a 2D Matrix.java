class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       return binarySearch(matrix,0,matrix.length*matrix[0].length-1,target);
    }
    private boolean binarySearch(int[][] mat,int left,int right,int target){
        //System.out.println("####");
        if(left>right) return false;
        int mid = (left + right)/2;
        int m  = mat[0].length;
        int row = mid/m;
        int col = mid%m;
        //System.out.println("[mid-row-col]"+mid+"-"+row+"-"+col);
        if(mat[row][col]==target) return true;
        if(target<mat[row][col]) return binarySearch(mat,left,mid-1,target);
        return binarySearch(mat,mid+1,right,target);
    }
​
    
}
