class Solution {
    public int[] decode(int[] encoded) {
         //System.out.println("New ");
        int[] perm=new int[encoded.length+1];
        int xor=0;
        for(int i=1;i<=encoded.length+1;i++){
            xor^=i;
        }
        //System.out.println(xor);
        perm[0]=xor;
        for(int i=1;i<encoded.length+1;i+=2){
           
            perm[0]^=encoded[i];
        }
         //System.out.println(perm[0]);
        for(int i=1;i<encoded.length+1;i++){
            perm[i]=perm[i-1]^encoded[i-1];
        }
        return perm;
        
    }
}
