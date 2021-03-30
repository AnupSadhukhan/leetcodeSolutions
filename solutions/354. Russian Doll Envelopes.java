class Solution {
    public int maxEnvelopes(int[][] env) {
        // O(n^2)
       /* if(env.length<=1) return env.length;
       Arrays.sort(env,(a,b)-> {
           return Integer.compare(b[0]*b[1], a[0]*a[1]);
       });
        int n=env.length;
        int[] dp=new int[n];
        int max=0;
        
        for(int i=0;i<n;i++){
            int w=env[i][0];
            int h=env[i][1];
            dp[i]=1;
            for(int j=0;j<i;j++){
               
                if(env[j][0]>w && env[j][1]>h){
                    
                   dp[i]=Math.max(dp[i],1+dp[j]);
                   
                 
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
        */
        //O(nlogn)
        if(env.length<=1) return env.length;
       Arrays.sort(env,(a,b)-> {
           if(a[0]==b[0]) return b[1]-a[1];
           return a[0]-b[0];
       });
        
        int n=env.length;
        int[] dp=new int[n];
        int len=0;
        
        for(int i=0;i<n;i++){
            
            int idx=Arrays.binarySearch(dp,0,len,env[i][1]);
            if(idx<0){
                idx=-(idx+1);
            }
            dp[idx]=env[i][1];
            if(idx==len){
                len++;
            }
        }
        return len;
      
