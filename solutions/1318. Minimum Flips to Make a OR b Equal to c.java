class Solution {
    public int minFlips(int a, int b, int c) {
        int min=0;
        
        for(int i=0;i<32;i++){
            if((c>>i & 1)==1 && (a>>i & 1)==0 && (b>>i & 1)==0){
                min++;
            }
            else if((c>>i & 1)==0){
                if((a>>i & 1)==1) min++;
                if((b>>i & 1)==1) min++;
            }
            
        }
        return min;
    }
}
