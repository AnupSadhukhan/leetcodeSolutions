class Solution {
    public void reverseString(char[] s) {
        if(s.length<2) return;
        reverse(s,0);
    }
    public void reverse(char[] s,int i){
        if(i==s.length/2-1){
           swap(s,i,s.length-1-i);
            return;
        }
        reverse(s,i+1);
        swap(s,i,s.length-1-i);
        //System.out.println(s[i]);
    }
    public void swap(char[] s,int l,int r){
        char c=s[l];
        s[l]=s[r];
        s[r]=c;
    }
}
