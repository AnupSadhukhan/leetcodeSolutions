class Solution {
    class GasStation{
        int index;
        int gas;
        int cost;
        GasStation(int index,int gas,int cost){
            this.index=index;
            this.gas=gas;
            this.cost=cost;
        }
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // O(n^2) - 147ms
       
        int n=gas.length;
        for(int i=0;i<n;i++){
           if(gas[i]<cost[i]) continue; 
            int gasAvailable=gas[i]-cost[i];
            int start=(i+1)%n;
            while(start!=i && gasAvailable+gas[start]>=cost[start]){
                //System.out.println("start "+start);
                gasAvailable=gasAvailable+gas[start]-cost[start];
                start=(start+1)%n;
            }
            if(start==i) return i;
        }
        return -1;
        
        // 200ms
        /* PriorityQueue<GasStation> queue=new PriorityQueue<>((a,b)->{
            return (a.gas-a.cost)-(b.gas-b.cost);
        });
         int n=gas.length;
        for(int i=0;i<n;i++){
            if(gas[i]>=cost[i]){
                queue.add(new GasStation(i,gas[i],cost[i]));
            }
        }
        
        while(!queue.isEmpty()){
            GasStation gasStation=queue.poll();
            
            int gasAvailable=gasStation.gas-gasStation.cost;
            int start=(gasStation.index+1)%n;
            while(start!=gasStation.index && gasAvailable+gas[start]>=cost[start]){
                //System.out.println("start "+start);
                gasAvailable=gasAvailable+gas[start]-cost[start];
                start=(start+1)%n;
            }
            if(start==gasStation.index) return gasStation.index;
        }
        return -1;
        */
    }
    
}
