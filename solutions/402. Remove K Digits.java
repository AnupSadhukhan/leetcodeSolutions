class Solution {
    /* if n == k return 0
    else if there is smaller digit after a digit then if we will delete greater
    digit, smaller digit will replace the position and give us less number, so
    we will delete higher digit as well as decrease k and i beacuse after deleting position
    has shifted one side to the left,
    we will do this process until we process till the end,
    after end if still k is greater than zero we have to remove digit from end
    until k becomes, because after processing the whole num i.e. deleting higer
    num if next nums is smaller, our new num will be in increasing sequence, so num
    higher number will reside at the end, so to minimize the value delete from end.
    
    once k is zero, check for leading zero and delete them as well after that return the num.
    */
    
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
