class Solution {
   /* public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean>dp = new HashMap<>();
        return helper(s,new HashSet<>(wordDict),dp);
    }
    private boolean helper(String s, HashSet<String>dict,HashMap<String,Boolean>dp){
        if(s.length()==0)return true;
        if(dict.contains(s))return true;
        
        if(dp.containsKey(s))return dp.get(s);
        
        for(int i=1;i<s.length();i++){
            String subs = s.substring(0,i);
            if(dict.contains(subs)&&helper(s.substring(i),dict,dp)){
                dp.put(subs,true);
                return true;
            }
        }
        dp.put(s,false);
        return false;
    }*/
     public boolean wordBreak(String s, List<String> words) {
      boolean[] dp=new boolean[s.length()+1];
         dp[0]=true;
        /*  Set<String> wordDict=new HashSet<>(words);
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
         return dp[s.length()];*/
         
         for(int i=0;i<s.length();i++){
             if(!dp[i]) continue;
             for(String word :words){
                 int high=i+word.length();
                 if(high<=s.length() && s.substring(i,high).equals(word)){
                     dp[high]=true;
                 }
             }
         }
         return dp[s.length()];
     
    }
    
    
}
