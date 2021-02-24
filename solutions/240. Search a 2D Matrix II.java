class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /* O(nlogm) */
        /*int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int left=matrix[i][0];
            int right=matrix[i][m-1];
            if(target>=left && target<=right && binarySearch(matrix,i,0,m-1,target)) return true;
        }
        return false;
        */
        /* O(n) */
         if(matrix == null || matrix.length==0 || matrix[0].length==0) return false;
        
        int column = matrix[0].length-1;
        int i=0;
        while(i< matrix.length && column>=0){
            if(matrix[i][column]==target){
                return true;
            } else if(matrix[i][column]>target){
                column--;
            } else {
                i++;
            }
        }
        return false;
    }
    public boolean binarySearch(int[][] matrix,int row,int start,int end,int target){
       // System.out.println("i "+row+" start "+start+" end "+end+" mid "+((start+end)/2));
        if(start>end) return false;
        int midIndex=(start+end)/2;
        int mid=matrix[row][midIndex];
        if(target==mid) return true;
        if(target<mid) return binarySearch(matrix,row,start,midIndex-1,target);
        else return binarySearch(matrix,row,midIndex+1,end,target);
    }
}
