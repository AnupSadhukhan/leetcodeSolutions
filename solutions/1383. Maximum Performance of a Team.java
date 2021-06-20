class Solution {
    /* create a 2d array, sort by efficiency, then one by one add to priority queue
     if queue size if full i.e. k then poll top element, at every iteration, calculate sum
     and result, then compare with prev res. update res as max res. return ans at the end. 
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=efficiency[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        long sum=0;
        long res=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            if(queue.size()==k) sum-=queue.poll();
            queue.add(arr[i][1]);
            sum+=arr[i][1];
            res=Math.max(res,(sum*arr[i][0]));
        }
        return (int)(res%mod);
    }
}
