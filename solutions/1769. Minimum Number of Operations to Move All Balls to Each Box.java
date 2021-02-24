class Solution {
    public int[] minOperations(String boxes) {
        char[] box=boxes.toCharArray();
        int[] prefix=new int[box.length];
        int[] suffix=new int[box.length];
        int[] op=new int[box.length];
        prefix[0]=0;
        int balls=(box[0]-'0');
        for(int i=1;i<box.length;i++){
            prefix[i]=prefix[i-1]+balls;
            balls+=(box[i]-'0');
            op[i]=prefix[i];
        }
        suffix[box.length-1]=0;
        balls=(box[box.length-1]-'0');
        for(int i=box.length-2;i>=0;i--){
            
             suffix[i]=suffix[i+1]+balls;
            balls+=(box[i]-'0');
            op[i]+=suffix[i];
        }
        
        return op;
        
    }
}
