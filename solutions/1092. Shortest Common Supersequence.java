class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int m=str1.length();
        int n=str2.length();
        
        String[][] dp=new String[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i*j==0){
                    dp[i][j]="";
                    continue;
                } 
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+str1.charAt(i-1);
                }
                else{
                    //System.out.println("".length());
                    //System.out.println(dp[i][j-1].length());
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j] : dp[i][j-1] ;
                }
            }
        }
        String s= dp[m][n];
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        for(char c : s.toCharArray()){
            while(i<m && str1.charAt(i)!=c){
                sb.append(str1.charAt(i++));
            }
            while(j<n && str2.charAt(j)!=c){
                sb.append(str2.charAt(j++));
            }
            sb.append(c);
            i++;
            j++;
        }
         while(i<m){
                sb.append(str1.charAt(i++));
            }
            while(j<n ){
                sb.append(str2.charAt(j++));
            }
        return sb.toString();
    }
    
}
