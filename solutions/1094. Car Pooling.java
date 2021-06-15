class Solution {
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
