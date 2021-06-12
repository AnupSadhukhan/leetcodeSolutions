class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target) return 0;
        if(stations.length==0){
            return -1;
        }
       
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        int i=0;
        int n=stations.length;
        int count=0;
        while((!queue.isEmpty() && startFuel<target) || (i<n && startFuel>=stations[i][0])){
            if(i<n && startFuel>=stations[i][0]){
                queue.offer(stations[i][1]);
                i++;
            }
            else{
                startFuel+=queue.poll();
                count++;
                
            }
        }
        return startFuel>=target?count:-1;
    }
}
