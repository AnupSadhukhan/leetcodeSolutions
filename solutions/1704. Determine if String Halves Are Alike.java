class Solution {
    public boolean halvesAreAlike(String s) {
       int count1=0;
        int count2=0;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length/2;i++){
            int idx=getIndex(c[i]);
            if(idx!=10){
                count1++;
            }
             
           
        }
        for(int i=c.length/2;i<c.length;i++){
           int idx=getIndex(c[i]);
            if(idx!=10){
                count2++;
            }
              
        }
        
        return count1==count2;
        
    }
    public int getIndex(char c){
        switch(c){
            case 'a': return 0;   
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u':return 4;
            case 'A': return 5;
