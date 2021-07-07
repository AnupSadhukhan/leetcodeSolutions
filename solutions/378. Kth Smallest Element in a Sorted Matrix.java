class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //11 ms O(nlog(n-k)) 
       /* if(k==1) return matrix[0][0];
        if(k==matrix.length*matrix[0].length) return matrix[matrix.length-1][matrix[0].length-1];
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(queue.size()==k && queue.peek()>matrix[i][j]){
                    queue.poll();
                    queue.offer(matrix[i][j]);
                }
                else if(queue.size()<k) queue.offer(matrix[i][j]);
            }
        }
        
        return queue.peek(); */
       /* 7ms O(nlogn) 
        int[] arr=new int[matrix.length*matrix[0].length];
        int index=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arr[index++]=matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1]; */
        
        // 0 ms O(log(MaxValue) * n )
        int n=matrix.length;
        int m=matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        while(low<=high){
            int mid=(low+high)/2;
            if(isNumberOfElemntsMoreThanOrEqualToK(matrix,mid,k,n)){
                // if num of elements greater or equal make high as mid - 1
                high = mid - 1;
            }
            else low=mid + 1;
        }
        return low;    
    }
    private boolean isNumberOfElemntsMoreThanOrEqualToK(int[][] matrix,int mid,int k,int n){
        // row wise check num of elemets greater than mid and add up to count by that for each row
        int row = n-1;
        int col = 0;
        int count=0;
        while(row>=0 && col<n){
            if(matrix[row][col]<=mid){
                count += (row + 1);
                col++; // check next column to find num of elems greater than mid
            }
            else{
                // if element is greater than mid, decrease row by 1
                row--;
            }
        }
        return count>=k;
    }
}
