class Solution {
//     public int minCut(String s) {
//         if(s==null || s.length()<=1) return 0;
        
//         char[] chs = s.toCharArray();
//         int[] minCut = new int[chs.length];
        
//         for(int i = 0; i<chs.length;i++){
//              minCut[i] = i;
//         }
        
        
//         for(int i = 1; i < chs.length ; i++){
           
            
//             // odd 
//             for(int start = i,end=i; start>=0 && end<chs.length && chs[start]==chs[end]; start--,end++){
               
//                 int cut = start==0?0:minCut[start-1]+1;
//                 minCut[end] = Math.min(minCut[end],cut);
                
//             }
            
//             // even
//             for(int start = i-1,end=i; start>=0 && end<chs.length && chs[start]==chs[end]; start--,end++){
//                 int cut = start==0?0:minCut[start-1]+1;
//                 minCut[end] = Math.min(minCut[end],cut);
                
//             }
//         }
​
        
//         return minCut[chs.length-1];
//     }
    
    // another way
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
​
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
