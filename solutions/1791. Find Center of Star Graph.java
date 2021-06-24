class Solution {
    public int findCenter(int[][] edges) {
       /* int[] indegree=new int[100001];
        int n=edges.length;
        for(int i=0;i<n;i++){
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            if(indegree[edges[i][0]]==n) return edges[i][0];
            if(indegree[edges[i][1]]==n) return edges[i][1];
            
        }
        return -1;
        */
        //O(1) -> as there will n indegree so, if we compare any two we will get result
         if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ){
            return edges[0][0];
        }
        if(edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1] ){
            return edges[0][1];
        }
        return 0;
    }
}
