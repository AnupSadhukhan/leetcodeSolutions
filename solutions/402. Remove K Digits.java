class Solution {
    public String removeKdigits(String num, int k) {
       int n=num.length();
        if(n==k) return "0";
        StringBuilder sb=new StringBuilder(num);
        for(int i=0;i<sb.length();i++){
            while(i>0 && sb.charAt(i)<sb.charAt(i-1) && k-->0) {
                sb.deleteCharAt(i-1);
                i--;
            }
        }
        while(k-->0){
            sb.deleteCharAt(sb.length()-1);
        }
       while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
​
    }
}
