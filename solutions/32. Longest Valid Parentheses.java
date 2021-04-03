public class Solution {
    public int longestValidParentheses(String s) {
        //System.out.println("###  -->  "+s);
        int max=0,l=0,r=0;
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                l++;
            }
            else r++;
            if(l==r){
                max=Math.max(max,2*r);
            }
            else if(l>=r){
                l=0;
                r=0;
            }
        }
         
        l=0;
        r=0;
        for(int i=c.length-1;i>=0;i--){
            if(c[i]=='('){
                l++;
            }
            else r++;
            if(l==r){
                max=Math.max(max,2*l);
            }
            else if(l>=r){
                l=0;
                r=0;
            }
        }
        
        return max;
        
    }
}
