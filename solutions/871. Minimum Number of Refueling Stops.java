class Solution {
    /* if start fuel is less than first station distance, our car will never make the target
     if startfuel is more than target then there is no need to refuel
     
     use priority queue which will store fuel that is available in stations, 
     priority queue will be in decending order because we want to do minimu refuel
     so our priority is to take max fuel whenever our car runs out of fuel.
     if car has enought fuel then we can go to next station hence, add fuel to 
     queue and increase index , else while queue is not empty refuel by
     polling fuel from queue, until car has enought fuel to go next station or target
     increase refuelcount as well,
     if we make to target return refuel count else return -1;
     */
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
