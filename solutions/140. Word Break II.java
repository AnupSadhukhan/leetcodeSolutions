class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      
        //take words one by one and match the word with the substring for that length strting from 0
        // if it matches then, we found a match, consider it in our sentence , do the same for rest substring
        List<String> res=new ArrayList<>();
        for(String str : wordDict){
            StringBuilder sb=new StringBuilder();
            if(str.length()<=s.length() && str.equals(s.substring(0,str.length()))){
                sb.append(str+" ");
                helper(s,str.length(),sb.length(),res,sb,wordDict);
            }
           
           
        }
        return res;
    }
    public void helper(String s,int index,int idx,List<String> li,StringBuilder sb,List<String> words){
       // base case, if index is grether than or equals of original string length then
        // there are no words left to process in the string
        // add the string into result and return
        if(index>=s.length()){
            
            // we are triming bcz, string contains extra space at the end of string
            li.add(sb.toString().trim());
           
            return;
        }
        //take words one by one and match the word with the substring for that length strting from index
        // if it matches then, we found a match, consider it in our sentence , do the same for rest substring
        
        for(String str : words){
          
            if(index+str.length()<=s.length() && str.equals(s.substring(index,index+str.length()))){
               
                sb.append(str+" ");
                //we are adding one more length in idx, bcz we are adding space in our sencetence 
                helper(s,index+str.length(),idx+str.length()+1,li,sb,words);
                // here idx is holding is holding starting position from where we have to delete chars, 
                // we have to delete chars in order to restore previous string that stringbuilder was holding
                // so that we can process other possibilities
                sb.delete(idx,sb.length());
            }
        }
    }
}
