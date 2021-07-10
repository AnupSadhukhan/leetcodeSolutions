class Solution {
    public int numDecodings(String s) {
        long[] dp=new long[s.length()+1];
        dp[0]=1;
        dp[1]=decodeSingleChar(s.charAt(0));
        for(int i=2;i<=s.length();i++){
            char prev = s.charAt(i-2);
            char cur = s.charAt(i-1);
            dp[i] += (decodeSingleChar(cur) * dp[i-1]);
            dp[i] += (decodeTwoChar(prev,cur) * dp[i-2]);
            dp[i]=dp[i]%1000000007;
        }
        return (int)dp[s.length()];
    }
    private int decodeSingleChar(char c){
        if(c=='*') return 9;
        if(c=='0') return 0;
        return 1;
    }
    private int decodeTwoChar(char prev, char cur){
        switch(prev){
            case '*' : 
                if(cur=='*'){
                    return 15;
                }
                else if(cur>='0' && cur<='6') return 2;
                return 1;
            case '1' : 
                if(cur=='*') return 9;
                return 1;
            case '2' : 
                if(cur=='*') return 6;
                if(cur>='0' && cur<='6') return 1;
                return 0;
        }
        return 0;
    }
}
​
