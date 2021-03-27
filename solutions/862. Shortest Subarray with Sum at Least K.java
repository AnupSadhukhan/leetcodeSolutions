class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] pre=new int[A.length];
        pre[0]=A[0];
        for(int i=1;i<A.length;i++){
            pre[i]=pre[i-1]+A[i];
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(pre[i]>=K){
                ans=Math.min(ans,i+1);
            }
            int ysum=pre[i];
            int th=ysum-K;
            while(!q.isEmpty() && pre[q.peekFirst()]<=th){
                ans=Math.min(ans,i-q.pollFirst());
            }
            while(!q.isEmpty() && pre[q.peekLast()]>=ysum){
                q.pollLast();
            }
            q.offerLast(i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
