class Solution {
   /* public boolean canReach(String s, int minJump, int maxJump) {
        char[] chs = s.toCharArray();
        if(chs[0]!='0' || chs[chs.length-1]!='0') return false;
        Queue<Integer> queue =  new LinkedList<>();
        queue.add(0);
        int index = 1;
        while(!queue.isEmpty() && index<chs.length){
            int peekedIndex = queue.peek();
           
            if(peekedIndex+maxJump<index){
                
                queue.poll();
                continue;
            } 
            else if(chs[index]=='0' ){
                
                if(peekedIndex+minJump<=index && peekedIndex+maxJump>=index){
                    if(index==chs.length-1) return true;
                    queue.add(index);
                   
                }
            }
            index++;
        }
        return false;
    } 
    */
    // 8ms
     public boolean canReach(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ])
                pre++;
           
            if (i > maxJ && dp[i - maxJ - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}
