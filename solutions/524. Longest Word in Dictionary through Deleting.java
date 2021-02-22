class Solution {
    public String findLongestWord(String s, List<String> d) {
        if(s==null || s.equals("") || d.size()==0) return "";
        Collections.sort(d);
        String max="";
         int len2=s.length();
        for(String str : d){
            if(str.length()<=s.length()){
                int i=0,j=0;
                int len1=str.length();
               
                for(i=0,j=0;i<len1 && j<len2;){
                    if(str.charAt(i)==s.charAt(j)){
                        i++;
                        j++;
                    }
                    else{
                        j++;
                    }
                }
                if(i==len1 && len1>max.length()){
                    max=str;
                }
            }
        }
        
        return max;
        
    }
}
