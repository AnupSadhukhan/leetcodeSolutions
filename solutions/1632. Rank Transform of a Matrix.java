class Solution {
    int[] p;
    public int[][] matrixRankTransform(int[][] A) {
        int m = A.length, n = A[0].length;
        
        // sort matrix by increasing number
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(A[i][j], new ArrayList<>());
                map.get(A[i][j]).add(new int[] {i,j});                
            }
        }
        
        // store the current rank of m rows + n columns
        int[] rank = new int[m+n], rank2;        
        
        for (int value : map.keySet()) {            
            List<int[]> list = map.get(value);            
            rank2 = rank.clone();
            p = create(m+n); // create union-find
            
            for (int[] a : list) {                
                int i = find(a[0]), j = find(a[1]+m);                                
                p[i] = j; // union                               
                rank2[j] = Math.max(rank2[i], rank2[j]); // the parent will store the maximum value.
            }
            
            for (int[] a : list) {
                int i = a[0], j = a[1], pi = find(i);       
                // update rank & A[i][j] with the maximum value of parent + 1 (the next minimum possible rank)
                rank[i] = rank[j+m] = A[i][j] = rank2[pi]+1;
            }  
        }
        
        return A;
    }
     
    private int[] create(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = i;
        return res;
    }
    
    private int find(int i) {
        return (i == p[i]) ? i : find(p[i]);
    }
}
