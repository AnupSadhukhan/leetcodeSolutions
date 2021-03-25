class Solution {
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] mat;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return ans;
        
        int n=matrix.length;
        int m=matrix[0].length;
        mat=matrix;
        boolean[][] pecific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(pecific,i,0);
            dfs(atlantic,i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(pecific,0,i);
            dfs(atlantic,n-1,i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlantic[i][j] && pecific[i][j]){
                    ans.add(Arrays.asList(new Integer[]{i,j}));
                }
            }
        }
        return ans;
    }
    public void dfs(boolean[][] reachable,int x,int y){
        reachable[x][y]=true;
