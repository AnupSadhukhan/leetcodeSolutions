class Solution {
    public int findIntegers(int n) {
        if(n==0) return 1;
        if(n==1) return 2;
        if(n<=3) return 3;
        int[] arr = new int[32];
        arr[0]=1;
        arr[1] = 2;
        arr[2] = 3;
        for(int i=3;i<=31;i++){
            arr[i]+=(arr[i-2]+arr[i-1]);
        }
        int k = 30, ans =0,prev_bit=0;
        while(k-- >= 0){
            if((n&(1<<k)) != 0){
                ans+=arr[k];
                if(prev_bit==1){
                    return ans;
                }
                prev_bit=1;
                
            }
            else prev_bit = 0;
            
        }
        return ans+1;
    }
    
}
