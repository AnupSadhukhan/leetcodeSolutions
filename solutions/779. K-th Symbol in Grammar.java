class Solution {
    public int kthGrammar(int N, int k) {
        if(N==2){
            return k==1?0:1;
        }
        if(N<2) return 0;
        int k1=k;
        k=k%2==0?k/2:(k/2)+1;
        //System.out.println("calling "+(N-1)+" , "+k);
        int prevK=kthGrammar(N-1,k);
        if(prevK==0){
            if(k1%2==0){
               // System.out.println("1. 0 even =1");
                return 1;
            }
             //System.out.println("2. 0 odd =0");
            return 0;
        }
        else{
            if(k1%2==0){
                 //System.out.println("3. 1 even =0");
                return 0;
            } 
            //System.out.println("4. 1 odd =1");
            
            return 1;
        }
    }
}
