class Solution {
    public int maximumWealth(int[][] accounts) {
        int m=accounts.length;
        int n=accounts[0].length;
        //System.out.println(m+" "+n);
        int max=0;
        int sum=0;
        for(int i=0;i<m;i++){
            sum=0;
            for(int j=0;j<n;j++){
                sum+=accounts[i][j];
            }
            max=max<sum?sum:max;
        }
        return max;
    }
}
