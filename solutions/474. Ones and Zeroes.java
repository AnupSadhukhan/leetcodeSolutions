class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
       int[][] dp=new int[m+1][n+1];
        for(int i=0;i<strs.length;i++){
            int one=0;
            int zero=0;
            for(char c : strs[i].toCharArray()){
                if(c=='0')zero++;
                else one++;
            }
            //System.out.println(m+",aaa "+n+" "+zero+" "+one);
            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                     //System.out.println(j+", "+k+" "+zero+" "+one);
                    dp[j][k]=Math.max(1+dp[j-zero][k-one],dp[j][k]);
                }
            }
        }
       return dp[m][n];
        //return helper(ones,zeros,0,m,n);
    }
    /*
    public int helper(int[] ones,int[] zeros,int i,int m,int n){
        if(i==zeros.length || (m<=0 && n<=0)) return 0;
        int x=0,y=0;
        if(m-zeros[i]>=0 && n-ones[i]>=0){
            x=1+helper(ones,zeros,i+1,m-zeros[i],n-ones[i]);
            
        }
        y=helper(ones,zeros,i+1,m,n);
        
        return Math.max(x,y);
