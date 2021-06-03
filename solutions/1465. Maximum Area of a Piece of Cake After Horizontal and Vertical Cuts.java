class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int lastH=0,lastV=0;
        int maxH=0,maxV=0;
        int mod=1000000007;
        for(int i=0;i<horizontalCuts.length;i++){
            maxH=Math.max(maxH,(horizontalCuts[i]-lastH)%mod);
            lastH=horizontalCuts[i];
        }
         maxH=Math.max(maxH,(h-lastH)%mod);
         for(int i=0;i<verticalCuts.length;i++){
            maxV=Math.max(maxV,(verticalCuts[i]-lastV)%mod);
            lastV=verticalCuts[i];
        }
         maxV=Math.max(maxV,(w-lastV)%mod);
        return (int)(((long)maxV*maxH)%mod);
    }
}
