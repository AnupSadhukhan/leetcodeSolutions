class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] dist =  new int[points.length][2];
        for(int i = 0; i < points.length; i++){
            dist[i][1] = (points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            dist[i][0] = i;
        }
        quickSelect(dist,0,points.length-1,k);
       int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=points[dist[i][0]];
        }
        return result;
        
    }
    private void quickSelect(int[][] dist,int start,int end,int k){
        if(start<end){
            int pi = partition(dist,start,end);
            if(pi==k) return;
            if(pi<k) quickSelect(dist,pi+1,end,k);
            if(pi>k) quickSelect(dist,start,pi-1,k);
        }
    }
    private int partition(int[][] dist,int start,int end){
        int pivot = dist[end][1];
        int index = start;
        for(int i=start;i<end;i++){
            if(dist[i][1]<pivot) {
                swap(dist,i,index);
                index++;
            }
        }
        swap(dist,index,end);
        return index;
    }
    private void swap(int[][] dist,int left, int right){
        int[] tmp = dist[left];
        dist[left]=dist[right];
        dist[right]=tmp;
    }
}
