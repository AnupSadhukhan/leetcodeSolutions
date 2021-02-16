class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> li=new ArrayList<String>();
        permute(S.toCharArray(),0,S.length(),li);
        return li;
    }
    public void permute(char[] arr,int i,int len,List<String> li){
       // Approch 1
       /* //System.out.println("i "+i);
        if(i>=len){
            //System.out.println(s);
            li.add(s);
            return li;
        }
        permute(s,i+1,len,li);
        if(s.charAt(i)>='a' && s.charAt(i)<='z'){
           // permute(s,i+1,len);
            char c=(char) ( s.charAt(i)-32);
            String str=s.substring(0,i)+c;
            if(i+1<len)
               str+=s.substring(i+1,len);
            permute(str,i+1,len,li);
        }
        else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
           // permute(s,i+1,len);
            //System.out.println("inside 2nd");
            char c=(char) ( s.charAt(i)+32);
            String str=s.substring(0,i)+c;
            if(i+1<len)
               str+=s.substring(i+1,len);
            permute(str,i+1,len,li);
        }
        
        */
        //Approch 2
