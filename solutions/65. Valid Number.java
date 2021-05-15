class Solution {
    public boolean isNumber(String s) {
        if(s==null || s.length()==0) return false;
        // integer or decimal
        // optional + or -
        int n=s.length();
        int index=0;
        if(s.charAt(index)=='+' || s.charAt(index)=='-'){
            if(s.length()==1) return false;
            index++;
        }
      
        while(index<n && s.charAt(index)>='0' && s.charAt(index)<='9'){
            index++;
        }
        if(index<n && s.charAt(index)=='.' ){
                
                // 1. At least one digit, followed by a dot '.'.
                // 2. At least one digit, followed by a dot '.', followed by at least one digit.
                // 3. A dot '.', followed by at least one digit.
            
                boolean rule1=index>0 && s.charAt(index-1)>='0' && s.charAt(index-1)<='9' ;
                boolean rule2=index>0 && index+1<n && (s.charAt(index-1)>='0' && s.charAt(index-1)<='9') && (s.charAt(index+1)>='0' && s.charAt(index+1)<='9');
                boolean rule3=index+1<n && (s.charAt(index+1)>='0' && s.charAt(index+1)<='9');
            
               // System.out.println("inside 1"+rule1+" "+rule2+" "+rule3);
                
                if(!rule1 && !rule2 && !rule3) return false;
               
                index++;     
                while(index<n && s.charAt(index)>='0' && s.charAt(index)<='9'){
                    index++;
                }
               
               
            }
           
            if(index<n && index>0  && (s.charAt(index)=='E' || s.charAt(index)=='e')){
                if((s.charAt(index-1)=='+' || s.charAt(index-1)=='-')) return false;
             
                index++;
                if(index>=n) return false;
                
                boolean isSign= s.charAt(index)=='+' || s.charAt(index)=='-' ;
                boolean isDigit=(s.charAt(index)>='0' && s.charAt(index)<='9');
                if(!isSign && !isDigit ) return false;
                index++;
                while(index<n && s.charAt(index)>='0' && s.charAt(index)<='9'){
                    index++;
                }
                
            } 
            
       
        return index==n && s.charAt(n-1)!='+' && s.charAt(n-1)!='-';
        
        
    }
}
