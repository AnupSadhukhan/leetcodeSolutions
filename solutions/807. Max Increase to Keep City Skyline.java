class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        //e.g horizontal=[8,7,9,3], vertical=[9,4,8,7]
        int[] horizontal=new int[n];
        int[] vertical=new int[n];
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                horizontal[i]=Math.max(horizontal[i],grid[i][j]);
                vertical[j]=Math.max(vertical[j],grid[i][j]);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max+=(Math.min(horizontal[i],vertical[j])-grid[i][j]);
            }
        }
        return max;
    }
}
