class Solution {
    public boolean isPowerOfThree(int n) {
        double x=(Math.log10(n)/Math.log10(3));
        return x%1==0;
    }
    
    /*public boolean isPowerOfThree(int n) {
        if(n==1 || n==3) return true;
        if(n<=2) return false;
       
        return (n%3==0 && n/3!=0 && isPowerOfThree(n/3));
    }*/
}
