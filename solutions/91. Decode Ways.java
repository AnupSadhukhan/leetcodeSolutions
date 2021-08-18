class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i = 2;i<=s.length();i++){
            char prev = s.charAt(i-2);
            char cur = s.charAt(i-1);
            dp[i]+=processSingleDigit(cur)*dp[i-1];
            dp[i]+=processDoubleDigit(prev,cur)*dp[i-2];
            
        }
        return dp[s.length()];
    }
    private int processSingleDigit(char cur){
        
        if(cur == '0' ) return 0;
        return 1;
    }
    private int processDoubleDigit(char prev, char cur){
        
        switch(prev){
            case '0' :
                 return 0;
                
            case '1' :
                return 1;
            case '2' : 
                if(cur>='0' && cur<='6') return 1;
                return 0;
        }
        return 0;
    }
}
