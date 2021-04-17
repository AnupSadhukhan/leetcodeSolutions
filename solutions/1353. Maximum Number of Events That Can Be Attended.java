class Solution {
    //we will sort the events according to start time ,if there is a conflict end time
    // we will increase free slot one by one, if there are any event whose start is equal or less than free slot
    // we will add them to queue, because we can attend the event which ends sooner or 1 day each event
    // if any event finishes then we will poll those ones, because we do not have free time for that
    // suppose two event have same time 1day duration, in that case we can only attend any one of them only
    // we are using priority queue to process the events
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });
        int min =Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int[] event : events){
            if(min>event[0])min=event[0];
            if(max<event[1])max=event[1];
        }
        int count=0,index=0;
        int free=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        while(free<=max){
            if(queue.isEmpty()){
                if(index<events.length){
                    free=events[index][0];
                }
                else break;
            }
            while(index<events.length && events[index][0]<=free){
                queue.offer(events[index++][1]);
            }
            while(!queue.isEmpty() && queue.peek()<free){
                queue.poll();
            }
            free++;
            if(!queue.isEmpty()){
                
                queue.poll();
                count++;
            }
            
        }
        return count;
    }
}
