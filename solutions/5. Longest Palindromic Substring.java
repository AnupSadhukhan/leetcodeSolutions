class Solution {
    public String longestPalindrome(String s) {
        if(s==null) return "";
        if(s.length()<2) return s;
        char[] chs=s.toCharArray();
        int n=chs.length;
        int max=1;
        String res=new String(chs[0]+"");
        int curLen=0;
        for(int i=0;i<n;i++){
            int left=i-1;
            int right=i+1;
            // odd length
            while(left>=0 && right<n && chs[left]==chs[right]){
                left--;
                right++;
            }
            left=left+1;
            right=right-1;
            curLen=right-left+1;
            if(curLen>max){
                res=new String(chs,left,curLen);
                max=curLen;
            }
            // even length
            if(i+1<n && chs[i]==chs[i+1]){
                left=i-1;
                right=i+2;
                while(left>=0 && right<n && chs[left]==chs[right]){
                    left--;
                    right++;
                }
                
                left=left+1;
                right=right-1;
                curLen=right-left+1;
​
                if(curLen>max){
                    res=new String(chs,left,curLen);
                    max=curLen;
                }
            }
            
        }
        return res;
    }
}
