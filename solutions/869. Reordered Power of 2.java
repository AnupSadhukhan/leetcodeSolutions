class Solution {
    public boolean reorderedPowerOf2(int N) {
        /*
        return permute((N+"").toCharArray(),0);
        */
        int[] ans=count(N);
        for(int i=0;i<32;i++){
            if(Arrays.equals(ans,count(1<<i))) return true;
        }
        return false;
    }
    public int[] count(int n){
        int[] arr=new int[10];
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
        return arr;
    }
    /*public boolean permute(char[] s,int i){
        if(i==s.length-1){
           // System.out.println(new String(s));
            String str=new String(s);
            if(str.equals(new Integer(str).toString()))
            return Integer.bitCount(Integer.parseInt(new String(s)))==1? true: false;
            return false;          
        }
        for(int start=i;start<s.length;start++){
            
            //System.out.println("calling swap : "+new String(s)+" i , start "+i+" "+start);
            //if(s[start]!='0'){
            swap(s,i,start);
