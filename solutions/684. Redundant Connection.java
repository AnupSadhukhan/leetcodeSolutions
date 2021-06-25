class Solution {
    // O(n^2)
    /*public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Set<Integer>[] graph=new HashSet[n];
        for(int i=0;i<edges.length;i++){
            graph[i]=new HashSet<>();
        }
        buildGraph(edges,graph);
        boolean[] vis;
        for(int i=edges.length-1;i>=0;i--){
            deleteEdge(edges[i],graph);
            vis=new boolean[edges.length];
            if(isConnected(graph,edges[i][0]-1,edges[i][1]-1,vis)) return edges[i];
            addEdge(edges[i],graph);
        }
        return new int[]{-1,-1};
        
    }
    private void buildGraph(int[][] edges,Set<Integer>[] graph){
        for(int[] edge : edges){
            addEdge(edge,graph);
        }
    }
    private void deleteEdge(int[] edge,Set<Integer>[] graph){
        graph[edge[0]-1].remove(edge[1]-1);
        graph[edge[1]-1].remove(edge[0]-1);
    }
    private void addEdge(int[] edge,Set<Integer>[] graph)
    {
        graph[edge[0]-1].add(edge[1]-1);
        graph[edge[1]-1].add(edge[0]-1);
    }
    private boolean isConnected(Set<Integer>[] graph,int start,int end,boolean[] vis){
        if(start==end) return true;
        vis[start]=true;
        for(int node : graph[start]){           
            if(!vis[node] && isConnected(graph,node,end,vis)) return true;
             vis[node]=true;
        }
        return false;
    }*/
    // O(n) 
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        Arrays.fill(parent,-1);
        
        for(int i=0;i<n;i++){
            int first=findParent(edges[i][0],parent);
            int second=findParent(edges[i][1],parent);
            if(first==second ) return new int[]{edges[i][0],edges[i][1]};
            else parent[second]=first;
        }
        return new int[]{-1,-1};
    }
    private int findParent(int node,int[] parent){
        if(parent[node]==-1) return node;
        // we have use path compression technique below,when we are calling find and find root
        // we are setting root for all child nodes , so that next time it find root without 
        // traversing all the way up to root
        return parent[node]=findParent(parent[node],parent);
    }
    
}
