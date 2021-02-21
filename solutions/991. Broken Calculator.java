class Solution {
    public int brokenCalc(int X, int Y) {
        if(X==Y) return 0;
        int ans=0;
        while(X<Y){
            if(Y%2==1){
                Y++;
                ans++;
            }
            else{
                Y=Y>>1;
                ans++;
            }
        }
        return ans+X-Y;
    }
}
