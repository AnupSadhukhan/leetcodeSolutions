class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
      Map<String,String> map=new HashMap<>();
     Map<String, String> vowel=new HashMap<String,String>();
    Set<String> set=new HashSet<String>();
      for(String s:wordlist){
          if(map.get(s.toLowerCase())==null){
              map.put(s.toLowerCase(),s);
          }
          set.add(s);
          
          vowel.putIfAbsent(s.toLowerCase().replaceAll("[aeiou]","#"),s);
      } 
       int idx=0;
        for(String s: queries){
            String lower=s.toLowerCase().replaceAll("[aeiou]","#");
           if(set.contains(s)){
               idx++;
               continue;
           }
           else if(map.get(s.toLowerCase())!=null){
               queries[idx++]=map.get(s.toLowerCase());
           }
            else if(vowel.get(lower)!=null){
                //System.out.println()
                queries[idx++]=vowel.get(lower);
            }
            else{
                queries[idx++]="";
            }
       }
