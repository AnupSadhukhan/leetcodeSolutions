class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDist=0;
        for(int i=0;i<32;i++){
            int bitValueOfX= x & 1;
            x=x>>1;
            int bitValueOfY=y & 1;
            y= (y>>1);
            if(bitValueOfX!=bitValueOfY){
                hammingDist++;
            }
        }
        return hammingDist;
    }
}
