class Solution {
    public double myPow(double x, int n) {
        double pow=power(x,n);
        //System.out.println("pow "+pow);
        if(n<0){
            //System.out.println(pow);
            return 1/pow;
        }
        return pow;
    }
    public double power(double x,int n){
        if(n==0) return 1;
        if(n==1 || n==-1) return x;
        
        if(n%2==0){
           
            double pow=power(x,n/2);
           
            return pow*pow;
        }
        else{
          
          double pow=power(x,n/2);
        
            return pow*pow*x;
        }
    }
}
