class Solution {
    public int divide(int dividend, int divisor) {
        int ans=0;
        if(divisor==Integer.MIN_VALUE) return dividend==divisor?1:0;
        if(dividend==Integer.MIN_VALUE){
            if(divisor==1) return Integer.MIN_VALUE;
            if(divisor==-1) return Integer.MAX_VALUE;
            dividend+=Math.abs(divisor);
            ans++;
        }
        ans+=Math.floor(Math.exp(Math.log(Math.abs(dividend))-Math.log(Math.abs(divisor))));
        return dividend>0 == divisor>0 ? ans :-ans;
    }
}
