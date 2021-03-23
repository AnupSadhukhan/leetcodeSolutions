class Solution {
    public int characterReplacement(String s, int k) {
        if(s==null || s.length()==0) return 0;
       
        char[] chs=s.toCharArray();
        int longest=Integer.MIN_VALUE;
         if(k==0){
             int len=1;
             longest=1;
             for(int i=1;i<chs.length;i++){
                 if(chs[i]==chs[i-1]){
                     len++;
                     
                 }
                 else{
                     len=1;
                 }
                 longest=len>longest?len:longest;
             }
             return longest;
         }
       
        int left=0;
        
        int max=0;
        int[] arr=new int[26];
        int change=0;
        int idx=-1;
        int maxval=0;
        for(int i=0;i<chs.length;i++){
           idx=chs[i]-'A';
            arr[idx]++;
           max=arr[idx]>arr[max]?idx : max;
        maxval=arr[max];
           change=i-left+1-arr[max];
            while(change>k && left<=i){
                arr[chs[left]-'A']--;
                if(arr[max]<maxval){
                    max=getMax(arr);
                    maxval=arr[max];
                }
                left++;
                change=i-left+1-arr[max];
                
            }
            longest=i-left+1>longest? i-left+1:longest;
        }
           
        return longest;
    }
    public int getMax(int[] arr){
        int max=0;
        for(int i=1;i<26;i++){
            if(arr[max]<arr[i]) max=i;
        }
        return max;
        
    }
}
