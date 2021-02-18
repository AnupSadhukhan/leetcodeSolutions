class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int commonDif=A[1]-A[0];
        int start=0;
        int end=1;
        int sum=0;
        //System.out.println("start + "+start);
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==commonDif){
                end=i;
                //System.out.println("com dif is same, end + "+end);
            }
            else{
               int n=end-start+1;
                if(n>=3)
                    sum+=(((n-1)*(n-2))/2);
                commonDif=A[i]-A[i-1];
                start=i-1;
                end=i;
                //System.out.println("com dif is not same, sum, start, end  "+sum+" "+start+" "+end);
            }
        }
        int n=end-start+1;
                if(n>=3)
                    sum+=(((n-1)*(n-2))/2);
        //System.out.println("at the end-> sum, start, end  "+sum+" "+start+" "+end);
        return sum;
    }
}
