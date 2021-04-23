class Solution {
    // logic is : we will count zero and ones
    // if cur char is not equal to last char then that means char is changing , here we can take 
    // min value of zero and one only if value of both these variable is greater than 0, 
    // so that first time it don't go into the block, so when both counter value is greater than 0 and 
    // after that any changes occur , we will take min value of bot an set count of zero or one to 1 accordingly
    
    public int countBinarySubstrings(String s) {
        int one=0,zero=0;
        char[] c=s.toCharArray();
        // one=c=='1'?1:0;
        // zero=~one;
        int max=0;
        for(int i=0;i<c.length;i++){
            
            if(i>0 && c[i]!=c[i-1] && one>0 && zero>0){
                max+=Math.min(one,zero);
                if(c[i]=='0') zero=1;
                else one=1;
            }
            else if(c[i]=='0') zero++;
            else one++;
        }
         max+=Math.min(one,zero);
        return max;
    }
}
