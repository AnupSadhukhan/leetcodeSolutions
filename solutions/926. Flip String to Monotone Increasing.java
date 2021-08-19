class Solution {
    public int minFlipsMonoIncr(String s) {
        if(s.length()==1) return 1;
        char[] chs = s.toCharArray();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        left[0] = chs[0]=='0'?0:1;
        for(int i=1;i<chs.length;i++){
            if(chs[i]=='1'){
                left[i]=1+left[i-1];
            }
            else left[i] = left[i-1];
        }
        right[chs.length-1] = chs[chs.length-1]=='1'?0:1;
        int min = chs.length;
        for(int i = chs.length-2;i>=0;i--){
            min = Math.min(min,left[i]+right[i+1]);
            if(chs[i]=='0'){
                right[i]=1+right[i+1];
            }
            else right[i]=right[i+1];
        }
        min = Math.min(min,right[0]);
        min = Math.min(min,left[chs.length-1]);
        
        return min;
        
    }
}
