class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    int first=findParent(i,parent);
                    int second=findParent(j,parent);
                    if(first!=second){
                        if(parent[first]<parent[second]){
                            parent[first]+=parent[second];
                            parent[second]=first;
​
                        } 
                        else{
                            parent[second]+=parent[first];
                            parent[first]=second;
                        }
                    }
                }
                
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]<0) count++;
        }
       
        return count;
    }
    private int findParent(int city,int[] parent){
        if(parent[city]<0) return city;
        parent[city]=findParent(parent[city],parent);
        return parent[city];
    }
}
