class Solution {
    // prerequisite : 560. Subarray Sum Equals K
    // We will do the prefix sum for every row, now the problem is
    // reduced to subarray sum for each row, if we need to consider multiple
    // columns, we will do cumaltive sum, so after doing prefix our matrix will be
    //  [0,1,1]                                         [0]     [0,1]       [0,1,1] | 1
    //  [1,2,3] we will do the searching 1st iteration :[1] then[1,2] then  [1,2,3] | 3 cuma sum=5
    //  [0,1,1]                                         [0]     [0,1]       [0,1,1] V 1
    // 2nd itr                               3rd itr
    // [1] |      [1,1] |                    [1] |
    // [2] | then [2,3] | sum up             [3] | sum up
    // [1] v      [1,1] V                    [1] V
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row=matrix.length,col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=matrix[i][j]+(j>0?matrix[i][j-1]:0);
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,count=0;
        for(int i=0;i<col;i++){
            for(int j=i;j<col;j++){
                map.clear();
                map.put(0,1);
                sum=0;
                for(int k=0;k<row;k++){
                    sum+=matrix[k][j]-(i>0? matrix[k][i-1] : 0);
                    count+=map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
}
