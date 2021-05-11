class Solution {
    // Time limit exceeds
    /*Map<String,Integer> map;
    public int maxScore(int[] cardPoints, int k) {
        map=new HashMap<>();
       
        return helper(0,cardPoints.length-1,cardPoints,k);
    }
    public int helper(int start,int end,int[] cards,int k){
        if(k==0 || start>end) return 0;
        String s=start+"-"+end+"-"+k;
        if(map.get(s)!=null) return map.get(s);
        int res=Math.max(cards[start]+helper(start+1,end,cards,k-1),cards[end]+helper(start,end-1,cards,k-1));
        map.put(s,res);
        return res;
    }
    */
    
    //We can do using dynamic programming certainly, but for this problem, as per 
    // constraint it will not work. So, we will use window sliding approch.
    // We will sum up values of all elements in then we will find max of sum-(sum of n-k)
    // elements, we will do sliding upto length of the array, and find the max value
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int x : cardPoints) sum+=x;
        if(k>=n) return sum;
        int max=0;
        int cur=0,left=0;
        for(int i=0;i<n;i++){
            cur+=cardPoints[i];
            if(i<n-k-1){
                continue;
            }
            if(i==n-k-1){
                 max=Math.max(max,sum-cur);
                continue;
            }
            cur-=cardPoints[left++];
            
           max=Math.max(max,sum-cur);
           
        }
        return max;
    }
    
    
}
