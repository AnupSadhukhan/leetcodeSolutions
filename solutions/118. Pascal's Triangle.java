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
/* another implementation
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res=new ArrayList<>();
        Integer[] prev={1};
        res.add(Arrays.asList(prev));
        if(numRows==1)  return res;
       
        for(int row=2;row<=numRows;row++){
            Integer[] cur=new Integer[row];
            int index=0;
            cur[index++]=1;
            for(int i=0;i<prev.length-1 && prev.length>1;i++){
                cur[index++]=prev[i]+prev[i+1];
            }
            cur[index]=1;
            res.add(Arrays.asList(cur));
            prev=cur;
        }
        return res;
    }
}
*/
