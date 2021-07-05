class Solution {
    boolean[] vis;
    boolean[] isInCurCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
       
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
      
        
        vis=new boolean[numCourses];
        isInCurCycle=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
           // System.out.println("i "+i);
            if(!vis[i] && isCycleExists(graph,i)) {
                 //System.out.println("r4eturn false ");
                return false;
            }
        }
        return true;
    }
    private boolean isCycleExists(List<Integer>[] graph,int start){
       // System.out.println("start "+start);
        if(isInCurCycle[start]) return true;
        if(vis[start]) return false;
        vis[start]=true;
        isInCurCycle[start]=true;
        for(int index : graph[start]){
            if( isCycleExists(graph,index)) {
                //System.out.println("return true ");
                return true;
            }
            
        }
        isInCurCycle[start]=false;
        return false;
    }
}
​
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//         if (prerequisites.length <= 1) {
//             return true;
//         }
        
//         Map<Integer, List<Integer>> map = getEdgesMap(prerequisites);
//         boolean[] visited = new boolean[numCourses];
//         boolean[] prerequisite = new boolean[numCourses];
