class Solution {
    /* create generic pattern from pattern string using map, 
       if char of pattern string is already mapped, then add that
       mapped char to stringbuilder else generate a new pattern or char map 
       for this char ,
       we will do the same for every words then check if mapping string of word 
       matches with mapping string of pattern string then we will add this word
       to result else not.
       */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result=new ArrayList<>();
        Set<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        int index=0;
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            Character ch=map.get(pattern.charAt(i));
            if(ch!=null){
                sb.append(ch);
            }
            else{
                char c=(char)(index+'a');
                sb.append(c);
                map.put(pattern.charAt(i),c);
                index++;
            }
          
        }
        set.add(sb.toString());
        for(String word : words){
            map=new HashMap<>();
            index=0;
            sb=new StringBuilder();
            for(int i=0;i<word.length();i++){
                Character ch=map.get(word.charAt(i));
                if(ch!=null){
                    sb.append(ch);
                }
                else{
                    char c=(char)(index+'a');
                    sb.append(c);
                    map.put(word.charAt(i),c);
                    index++;
                }
            }
            if(set.contains(sb.toString())) result.add(word);
            
        }
        
       return result;
    }
}
