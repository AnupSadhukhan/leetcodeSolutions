class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp=new int[2][numRows+1];
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        li.add(1);
        dp[0][1]=1;
        res.add(li);
        for(int i=1;i<numRows;i++){
            li=new ArrayList<>();
            for(int j=1;j<=i+1;j++){
                dp[(i)%2][j]=dp[(i-1)%2][j-1]+dp[(i-1)%2][j];
                li.add(dp[(i)%2][j]);
            }
            res.add(li);
        }
        return res;
    }
}
