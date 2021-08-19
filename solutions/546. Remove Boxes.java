class Solution {
    public int removeBoxes(int[] boxes) {
        int size = boxes.length;
        int[][][] dp = new int[size][size][size];
         //return removeBoxesSub(boxes,0,size-1,0,dp);
        return remove(dp,boxes,0,size-1,0);
    }
    private int remove(int[][][] dp,int[] boxes,int left,int right,int k){
        if(left>right) return 0;
        if(dp[left][right][k]>0) return dp[left][right][k];
        if(left==right) return (k+1)*(k+1);
        int i0 = left, k0 = k;
        for(;i0+1<=right && boxes[i0+1]==boxes[i0];i0++,k0++);
        int res = (k0+1)*(k0+1) + remove(dp,boxes,i0+1,right,0);
        
        for(int i = i0+1;i<=right;i++){
            if(boxes[i0]==boxes[i]){
                res = Math.max(res,remove(dp,boxes,i0+1,i-1,0)+remove(dp,boxes,i,right,k0+1));
            }
        }
        dp[left][right][k] = res;
        return dp[left][right][k];
    }
        private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
​
        int i0 = i, k0 = k; 
        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++); 
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);
​
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }
​
        dp[i0][j][k0] = res; 
        return res;
    }
}
