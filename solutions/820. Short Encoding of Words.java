class Solution {
    public int minimumLengthEncoding(String[] words) {
       /* Approch 1 */
        /*
        Arrays.sort(words, (w1,w2) ->{
            if(w1.length()>w2.length()){
                return -1;
            }
            if(w1.length()<w2.length()) return 1;
            return 0;
            
        });
       
        StringBuilder sb=new StringBuilder();
        sb.append(words[0]+"#");
        for(int i=1;i<words.length;i++){
            int idx=sb.lastIndexOf(words[i]);
            if(idx!=-1 && sb.charAt(idx+words[i].length())=='#'){
                continue;
            }
            else{
                sb.append(words[i]+'#');
            }
            
        }
       
        return sb.length();
        */
        Set<String> set=new HashSet<String>();
        for(String s : words){
            set.add(s);
        }
        for(String s : words){
            for(int i=1;i<s.length();i++){
                set.remove(s.substring(i));
            }
        }
        int len=0;
        for(String s : set){
            
            len+=s.length()+1;
        }
        return len;
    }
}
