class Solution {
    public boolean hasAllCodes(String s, int k) {
        /* approch 1*/
        /*
        int[] arr=new int[1<<k];
        char[] chs=s.toCharArray();
       // System.out.println("new : ");
        for(int i=0;i+k-1<chs.length;i++){
            arr[getDecimal(chs,k,i,i+k-1)]++;
        }
        for(int i=0;i<(1<<k);i++){
            if(arr[i]==0) return false;
        }
        return true;
        */
        
        int size=1<<k;
        boolean[] arr=new boolean[size];
        int mask=size-1;
        int value=0;
        char[] chs=s.toCharArray();
        for(int i=0;i<chs.length;i++){
            value = (value<<1 & mask) | (chs[i]-'0');
            if(i>=k-1 && !arr[value]){
                arr[value]=true;
                if(--size==0) return true;
                
            }
        }
        return false;
        
    }
    /*
    int getDecimal(char[] binary,int k,int start,int end){
        int num=0;
        //System.out.println("start "+start+" end "+end);
        for(int i=end;i>=start;i--){
            num+=(Integer.parseInt(binary[i]+"")* 1<<end-i);
        }
        //System.out.println("num : "+num);
        return num;
    }
    */
}
