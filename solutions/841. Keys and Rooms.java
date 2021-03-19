class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<Integer>();
        q.offer(0);
        boolean[] vis=new boolean[rooms.size()];
        vis[0]=true;
        while(!q.isEmpty()){
            int idx=q.poll();
            for(int i : rooms.get(idx)){
                if(!vis[i]){
                    q.offer(i);
                    vis[i]=true;
                }
            }
            
        }
        
        for(int i=0;i<vis.length;i++){
            if(!vis[i]) return false;
        }
        return true;
        
        
    }
}
