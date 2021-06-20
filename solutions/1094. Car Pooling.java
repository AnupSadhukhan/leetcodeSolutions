class Solution {
    /* Approch 1 O(nlogn): sort trips as per start location followed by end location
        use priorityqueue to keep track of person entering to car along with their destination
        before starting a trip check runnng while, whether there are passengers whose destination already been passed, then 
        release their seat, if at any point capacity or seat is less than passengers return false
        as we can not do this car pooling else reserve seat for those passengers i.e. decarese seat or capacity
        add passegters and destination to queue.
        
        if we can complete all trips return true else false;
        
        approch 2 O(n) : 
          use a array, for every trip increase value by passengers at index start trip location
          and decrease value by passengers at index of end trip location,
          after processing do
          capacity-=value of array 
          if at any index value is negative, that means all trips can not be ompleted
          */
    
   /* public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->{
            if(a[1]==b[1]) return a[2]-b[2];
            return a[1]-b[1];
        });
        
        
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        
        for(int i=0;i<trips.length;i++){
            
            while(!queue.isEmpty() && queue.peek()[0]<=trips[i][1]){
                capacity+=queue.poll()[1];
            }
            if(capacity>=trips[i][0]){
                capacity-=trips[i][0];
            }
            else {
                return false;
            }
            
            queue.add(new int[]{trips[i][2],trips[i][0]});
        }
        return true;
    }*/
      public boolean carPooling(int[][] trips, int capacity) {
        int prev = 0;
        int[] stops = new int[1001];
        for(int[] t : trips){
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for(int i : stops){
            capacity -= i;
            if(capacity < 0) return false;
        }
        return true;
    }
}
